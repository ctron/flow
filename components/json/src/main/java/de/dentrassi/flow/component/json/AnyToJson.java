package de.dentrassi.flow.component.json;

import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import de.dentrassi.flow.ComponentContext;
import de.dentrassi.flow.spi.component.SimpleTransformationComponent;

public class AnyToJson extends SimpleTransformationComponent<Object, String> {

    private Gson gson;

    public AnyToJson() {
        super(Object.class, String.class);
    }

    @Override
    public void start(final Map<String, String> initializers, final ComponentContext context) {
        super.start(initializers, context);
        this.gson = new GsonBuilder().create();
    }

    @Override
    public String convertValue(final Object input) {
        return this.gson.toJson(input);
    }

}
