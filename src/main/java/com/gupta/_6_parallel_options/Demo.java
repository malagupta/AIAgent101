package com.gupta._6_parallel_options;

import dev.langchain4j.agentic.AgenticServices;
import dev.langchain4j.agentic.UntypedAgent;

import java.util.Map;

public class Demo {
    public static void main(String[] args) {
        var model = ModelConfig.create();

        QuickCookAgent cook = AgenticServices.agentBuilder(QuickCookAgent.class)
                                             .chatModel(model)
                                             .build();

        CasualServingAgent casualServing = AgenticServices.agentBuilder(CasualServingAgent.class)
                                                   .chatModel(model)
                                                   .build();

        RestaurantServingAgent restaurantServingAgent = AgenticServices.agentBuilder(RestaurantServingAgent.class)
                                                           .chatModel(model)
                                                           .build();

        ServingOptions servingOptions = AgenticServices.parallelBuilder(ServingOptions.class)
                                                       .subAgents(casualServing, restaurantServingAgent)
                                                       .output(scope -> Map.of(
                                                               "Casual", scope.readState("casualServing", "Unavailable"),
                                                               "Restaurant", scope.readState("restaurantServing", "Unavailable")
                                                       ))
                                                       .build();

        UntypedAgent workflow = AgenticServices.sequenceBuilder()
                                               .subAgents(cook, servingOptions)
                                               .outputKey("servingOptions")
                                               .build();

        Object result = workflow.invoke(Map.of("duration", 20));

        System.out.println(result);
    }
}