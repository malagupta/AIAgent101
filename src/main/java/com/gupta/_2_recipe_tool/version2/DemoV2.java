package com.gupta._2_recipe_tool.version2;

import com.gupta._2_recipe_tool.FoodOrderAssistant;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.service.tool.ToolArgumentsErrorHandler;
import dev.langchain4j.service.tool.ToolExecutionErrorHandler;

public class DemoV2 {

    // adds the following to avoid runtime warnings:
    // .toolArgumentsErrorHandler(ToolArgumentsErrorHandler.sendExceptionMessageToLlm())
    // .toolExecutionErrorHandler(ToolExecutionErrorHandler.failInvocationUnlessVisibleToLlm())
    //
    // Complicates the initial logic. Show if asked or if time permits.


    public static void main(String[] args) {
        FoodOrderAssistant assistant = AiServices.builder(FoodOrderAssistant.class)
                .chatModel(ModelConfig.create())
                .tools(new MenuToolV2())
                .toolArgumentsErrorHandler(ToolArgumentsErrorHandler.sendExceptionMessageToLlm())
                .toolExecutionErrorHandler(ToolExecutionErrorHandler.failInvocationUnlessVisibleToLlm())
                .build();

        String request = """
                            I want a dish with bread, tomato, and cheese. 
                            Should be quick to make""";
        try {
            System.out.println(assistant.suggest(request));
        } catch (RuntimeException e) {
            System.out.println("""
                    Sorry, I could not complete the recipe request right now.
                    Please try again later.
                    """);
        }
    }
}