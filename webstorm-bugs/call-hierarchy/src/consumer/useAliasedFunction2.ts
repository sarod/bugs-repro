import module1 from "../module1WithDefaultExport/index";
import {function2} from "../module2WithNamedReExports";

export const myFunc = () => {
    module1.function1('22')

    function2('22')
}
