package bugs.repro;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class MyDataClass {

    public abstract String getProp1();    


    public static MyDataClass create(String prop1) {
        return new AutoValue_MyDataClass(prop1);
    }

}
