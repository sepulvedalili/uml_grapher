package fr.lernejo.umlgrapher;

import java.lang.reflect.Modifier;

public class UmlGraph {
    private final Class<?>[] classes;
    public UmlGraph(Class<?>... classes) {
        this.classes = classes;
    }
    public String as(GraphType format) {
        if (format == GraphType.Mermaid) {
            String graph = "classDiagram";

            for(Class<?> theClass : classes){
                boolean isInterface = Modifier.isInterface(theClass.getModifiers());
                graph += "\nclass %s %s".formatted(
                    theClass.getSimpleName(),
                    isInterface ? "{\n    <<interface>>\n}\n" : "\n"
                );
            }

            return graph;
        }
        return "";
    }

}
