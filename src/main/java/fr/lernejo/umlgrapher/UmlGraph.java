package fr.lernejo.umlgrapher;

import java.lang.reflect.Modifier;

public class UmlGraph {
    private final Class<?> theClass;
    public UmlGraph(Class<?> theClass) {
        this.theClass = theClass;
    }
    public String as(GraphType format) {
        boolean isInterface = Modifier.isInterface(theClass.getModifiers());
        if (format == GraphType.Mermaid) {
            return """
                classDiagram
                class %s %s
                """.formatted(
                    theClass.getSimpleName(),
                    isInterface ? "{\n    <<interface>>\n}" : ""
                );
        }
        return "";
    }

}
