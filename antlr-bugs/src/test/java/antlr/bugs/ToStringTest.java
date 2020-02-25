package antlr.bugs;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.Trees;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

public class ToStringTest {
    @Test
    public void treesToStringShouldNotThrowWith2000() {
        String text = generateTreeAsText(2500);
        CharStream charStream = CharStreams.fromString(text);


        TreeLexer lexer = new TreeLexer(charStream);

        CommonTokenStream tokenStream = new CommonTokenStream(lexer);

        TreeParser parser = new TreeParser(tokenStream);

        TreeParser.NodeContext result = parser.node();

        assertThatCode(
                () -> Trees.toStringTree(result)
        ).doesNotThrowAnyException();


    }

    @Test
    public void treesToStringShouldNotThrow() {
        String text = generateTreeAsText(1000);
        CharStream charStream = CharStreams.fromString(text);


        TreeLexer lexer = new TreeLexer(charStream);

        CommonTokenStream tokenStream = new CommonTokenStream(lexer);

        TreeParser parser = new TreeParser(tokenStream);

        TreeParser.NodeContext result = parser.node();

        assertThatCode(
                () -> Trees.toStringTree(result)
        ).doesNotThrowAnyException();


    }

    private String generateTreeAsText(int depth) {
        String treeDef = "(a,b)";
        for (int i = 0; i < depth; i++) {
            treeDef = treeDef.replace("b", "(a,b)");
        }
        return treeDef;
    }

}
