package com.project.work.service;

import com.project.work.model.Difficult;
import com.project.work.model.Solution;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class SolutionService {

    private final Log log = LogFactory.getLog(this.getClass());

    private static final String FIRST_SOLUTION_PATH = "src/main/resources/solutions/first.txt";
    private static final String SECOND_SOLUTION_PATH = "src/main/resources/solutions/second.txt";
    private static final String THIRD_SOLUTION_PATH = "src/main/resources/solutions/third.txt";

    public Solution getSolutionFirst() {
        Solution solution = new Solution();
        StringBuilder readedSolution = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(FIRST_SOLUTION_PATH))) {
            String currentLine = br.readLine();
            while (currentLine != null) {
                readedSolution.append(currentLine);
                readedSolution.append("<br>");
                currentLine = br.readLine();
            }
        } catch (IOException e) {
            log.error("Error with reading the first solution...");
            e.printStackTrace();
        }
        solution.setSolution(readedSolution.toString());
        solution.setDifficult(Difficult.MEDIUM);
        return solution;
    }

    public void setThisSolutionToClipboard(Solution solution) {
        StringSelection selection = new StringSelection(solution.getSolution().replaceAll("<br>", "\n"));
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
    }
}
