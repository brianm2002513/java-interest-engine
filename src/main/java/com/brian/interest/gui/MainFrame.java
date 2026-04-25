package com.brian.interest.gui;

import com.brian.interest.service.InterestService;
import javax.swing.*;
import java.awt.*;

/**
 * Modernized GUI for the Interest Calculator.
 * Now follows the "View" part of the MVC pattern.
 */
public class MainFrame extends JFrame {

    private JTextField tfClientName, tfPrincipalAmount, tfRate, tfYears;
    private JTextArea taResults;
    private JButton btnCalculate;
    
    // The "Brain" is now external
    private final InterestService interestService;

    public MainFrame() {
        this.interestService = new InterestService();
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Elite Interest Engine");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        inputPanel.add(new JLabel("Client Name:"));
        tfClientName = new JTextField();
        inputPanel.add(tfClientName);

        inputPanel.add(new JLabel("Principal Amount (R):"));
        tfPrincipalAmount = new JTextField();
        inputPanel.add(tfPrincipalAmount);

        inputPanel.add(new JLabel("Annual Interest Rate (%):"));
        tfRate = new JTextField();
        inputPanel.add(tfRate);

        inputPanel.add(new JLabel("Number of Years:"));
        tfYears = new JTextField();
        inputPanel.add(tfYears);

        inputPanel.add(new JLabel());
        btnCalculate = new JButton("Calculate");
        btnCalculate.setBackground(new Color(70, 130, 180));
        btnCalculate.setForeground(Color.WHITE);
        btnCalculate.setFocusPainted(false);
        inputPanel.add(btnCalculate);

        add(inputPanel, BorderLayout.NORTH);

        taResults = new JTextArea();
        taResults.setFont(new Font("Monospaced", Font.PLAIN, 12));
        taResults.setEditable(false);
        taResults.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.GRAY),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
            
        JScrollPane scrollPane = new JScrollPane(taResults);
        add(scrollPane, BorderLayout.CENTER);

        btnCalculate.addActionListener(e -> handleCalculation());
    }

    private void handleCalculation() {
        try {
            String clientName = tfClientName.getText().trim();
            double principal = Double.parseDouble(tfPrincipalAmount.getText().trim());
            double rate = Double.parseDouble(tfRate.getText().trim()) / 100.0;
            int years = Integer.parseInt(tfYears.getText().trim());

            if (clientName.isEmpty()) throw new Exception("Client name required.");

            // Delegate math to the service
            double simple = interestService.calculateSimpleInterest(principal, rate, years);
            double compound = interestService.calculateCompoundInterest(principal, rate, years);

            displayResults(clientName, principal, rate, years, simple, compound);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void displayResults(String name, double p, double r, int t, double s, double c) {
        StringBuilder sb = new StringBuilder();
        sb.append("Calculation Results for: ").append(name).append("\n");
        sb.append("------------------------------------------\n");
        sb.append(String.format("Principal:         R%,.2f\n", p));
        sb.append(String.format("Annual Rate:      %.2f%%\n", r * 100));
        sb.append(String.format("Period:            %d Years\n", t));
        sb.append("------------------------------------------\n");
        sb.append(String.format("Simple Interest:   R%,.2f\n", s));
        sb.append(String.format("Compound Interest: R%,.2f\n", c));
        sb.append(String.format("Final Balance (C): R%,.2f\n", p + c));
        
        taResults.setText(sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }
}
