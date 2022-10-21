package fr.lernejo.umlgrapher;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

@Command(name = "launcher", mixinStandardHelpOptions = true, version = "UMLGraph 1.0", description = "UMLGraph")
public class Launcher implements Callable<Integer> {

    @Option(names = {"-c", "--classes"}, required = true, description = "Select classes to analyse")
    private Class<?>[] classes;

    @Option(names = {"-g", "--graph-type"}, defaultValue = "Mermaid", description = "Select graph type")
    private String graphType;

    @Override
    public Integer call() throws Exception {
        UmlGraph graph = new UmlGraph(classes);
        System.out.println(graph.as(GraphType.valueOf(graphType)));
        return null;
    }

    public static void main(String... args){
        int exitCode = new CommandLine(new Launcher()).execute(args);
        System.exit(exitCode);
    }
}
