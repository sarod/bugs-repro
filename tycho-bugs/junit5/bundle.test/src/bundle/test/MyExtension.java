package bundle.test;

import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class MyExtension implements BeforeEachCallback {
	@Override
	public void beforeEach(ExtensionContext context) throws Exception {
		// This would fail pre junit 5.4
		System.out.println(context.getTestInstances());

	}
}
