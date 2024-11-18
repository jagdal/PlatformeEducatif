package com.exemple.platformeeducatif.Solution;

import java.util.ArrayList;
import java.util.List;

public class SolutionManager {
    private static SolutionManager instance;
    private List<Solution> causes;

    private SolutionManager() {
        causes = new ArrayList<>();
    }

    public static synchronized SolutionManager getInstance() {
        if (instance == null) {
            instance = new SolutionManager();
        }
        return instance;
    }

    public List<Solution> getCauses() {
        return causes;
    }

    public void addCause(Solution cause) {
        causes.add(cause);
    }
}
