package com.dilli;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by dilli on 3/25/2017.
 */
public class AgileOrWaterFall extends JFrame{
    private JLabel projectNameLabel;
    private JPanel rootPanel;
    private JTextField projectName;
    private JLabel programmersLabel;
    private JTextField programmersText;
    private JCheckBox deadlinesSchedulesCheckBox;
    private JCheckBox experienceRequirementCheckBox;
    private JCheckBox qualityControlCheckBox;
    private JCheckBox earlyIntegrationCheckBox;
    private JCheckBox earlyWorkingModelCheckBox;
    private JButton recommendButton;
    private JLabel RecommendMessageLabel;
    private JButton quitButton;

    private boolean deadlinesSchedules;
    private boolean experienceRequirement;
    private boolean qualityControl;
    private boolean earlyIntegration;
    private boolean earlyWorkingModel;
    private boolean isProgrammer;


    public AgileOrWaterFall(){
        super("Agile or WaterFall");
        setContentPane(rootPanel);
        pack();
        setSize(new Dimension(400,350));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        deadlinesSchedulesCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                deadlinesSchedules = deadlinesSchedulesCheckBox.isSelected();
            }
        });

        experienceRequirementCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                experienceRequirement = experienceRequirementCheckBox.isSelected();
            }
        });

        qualityControlCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                qualityControl = qualityControlCheckBox.isSelected();
            }
        });

        earlyIntegrationCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                earlyIntegration = earlyIntegrationCheckBox.isSelected();
            }
        });

        earlyWorkingModelCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                earlyWorkingModel = earlyWorkingModelCheckBox.isSelected();
            }
        });
        recommendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String programmers = programmersText.getText();
                String myProjectName = projectName.getText();
                updateResults(myProjectName,programmers);
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int quit = JOptionPane.showConfirmDialog(AgileOrWaterFall.this,"Are you sure you want to quit?",
                        "Quit",JOptionPane.OK_CANCEL_OPTION);
                if(quit == JOptionPane.OK_OPTION){
                    System.exit(0);
                }
            }
        });
    }

    private void updateResults(String project,String pro){

        int noOfProgrammers  = Integer.parseInt(pro);
        if(noOfProgrammers<=30){
            isProgrammer = true;
        }else {
            isProgrammer = false;
        }
        String results = ( (isProgrammer && earlyIntegration &&  !deadlinesSchedules && !experienceRequirement && !qualityControl
                && !earlyWorkingModel)) ? project + " project should use Agile" :project + " project should use Waterfall";
        RecommendMessageLabel.setText(results);
    }
}
