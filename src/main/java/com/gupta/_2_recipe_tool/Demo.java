package com.gupta._2_recipe_tool;

import dev.langchain4j.service.AiServices;

/** Ask the audience:
 * a) What if I comment out the .tools(new MenuTool())
 *    Will the code still run?
 *    The answer is no because it is mentioned in the
 *    SystemMessage prompt.
 */


/**
 * Lab 2 (Constraints: Tool)
 *
 * Call a LLM with a request, LLMs could access tool and then output the response
 * One constraint.
 */
public class Demo {
    public static void main(String[] args) {
        FoodOrderAssistant assistant = AiServices.builder(FoodOrderAssistant.class)
                                                 .chatModel(ModelConfig.create())
                                                 .tools(new MenuTool())
                                                 .build();

        String request = """
                            I want a dish with bread, tomato, and cheese. 
                            Should be quick to make""";

        System.out.println(assistant.suggest(request));
    }
}
