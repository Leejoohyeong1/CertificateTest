package lee.com.certificatetest.DataModel;

import java.util.ArrayList;

public class CertificateProblem {
    String Problem;
    String Problemview;
    String Answer;
    ArrayList<Passage> Passages;

    public String getProblem() {
        return Problem;
    }

    public void setProblem(String problem) {
        Problem = problem;
    }

    public String getProblemview() {
        return Problemview;
    }

    public void setProblemview(String problemview) {
        Problemview = problemview;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }

    public ArrayList<Passage> getPassages() {
        return Passages;
    }

    public void setPassages(ArrayList<Passage> passages) {
        Passages = passages;
    }
}
