package com.niekenerik;

import com.niekenerik.interfaces.Node;

import java.util.HashMap;
import java.util.ServiceLoader;

public class NodeFactory {

    private static HashMap<String, Node> nodes;
    private static final ServiceLoader<Node> loader;

    static {
        nodes = new HashMap<String, Node>();
        loader = ServiceLoader.load(Node.class);

        for (Node node : loader) {
            nodes.put(node.getClass().getSimpleName(), node);
        }
    }

    public static final Node create(final String type, String name) {
        if (nodes.containsKey(type)) {
            return nodes.get(type).copy(name);
        }

        final String message = String.format("Node '%s' was not found, is the services file up to date?", type);
        throw new IllegalArgumentException(message);
    }
}
