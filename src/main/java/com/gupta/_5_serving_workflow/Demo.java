package com.gupta._5_serving_workflow;

import dev.langchain4j.agentic.AgenticServices;
import dev.langchain4j.agentic.UntypedAgent;

import java.util.Map;

public class Demo {
    public static void main(String[] args) {
        var model = ModelConfig.create();

        // Create an agent that suggests a recipe within a time limit.
        QuickCookAgent cook = AgenticServices.agentBuilder(QuickCookAgent.class)
                                             .chatModel(model)
                                             .build();

        // Create an agent that recommends how to serve the recipe.
        ServingAdvisorAgent servingAdvisor = AgenticServices.agentBuilder(ServingAdvisorAgent.class)
                                                            .chatModel(model)
                                                            .build();

        // Create a workflow: recipe suggestion first, serving advice second.
        UntypedAgent workflow = AgenticServices.sequenceBuilder()
                                               .subAgents(cook, servingAdvisor)
                                               .outputKey("servingAdvice")
                                               .build();

        System.out.println(workflow.invoke(Map.of("duration", 30)));
    }
}



