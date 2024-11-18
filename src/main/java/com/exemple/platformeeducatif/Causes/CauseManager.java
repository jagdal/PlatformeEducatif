package com.exemple.platformeeducatif.Causes;

import java.util.ArrayList;
import java.util.List;

public class CauseManager {
    private static CauseManager instance;
    private List<Cause> causes;

    private CauseManager() {
        causes = new ArrayList<>();
    }

    public static synchronized CauseManager getInstance() {
        if (instance == null) {
            instance = new CauseManager();
        }
        return instance;
    }

    public List<Cause> getCauses() {
        return causes;
    }

    public void addCause(Cause cause) {
        causes.add(cause);
    }
}
