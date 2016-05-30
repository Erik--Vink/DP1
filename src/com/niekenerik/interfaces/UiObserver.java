package com.niekenerik.interfaces;

import java.util.ArrayList;
import java.util.HashMap;

public interface UiObserver {

    void update(HashMap<Node,ArrayList<String>> nodes);

}
