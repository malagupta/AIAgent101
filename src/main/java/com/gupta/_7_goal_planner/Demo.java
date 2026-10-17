package com.gupta._7_goal_planner;

import dev.langchain4j.agentic.AgenticServices;
import dev.langchain4j.agentic.UntypedAgent;
import dev.langchain4j.agentic.patterns.goap.GoalOrientedPlanner;

import java.util.Map;

public class Demo {
    public static void main(String[] args) {
        var model = ModelConfig.create();

        var durationExtractor = AgenticServices.agentBuilder(DurationExtractorAgent.class)
                                               .chatModel(model)
                                               .build();

        var cook = AgenticServices.agentBuilder(QuickCookAgent.class)
                                  .chatModel(model)
                                  .build();

        var casualServing = AgenticServices.agentBuilder(CasualServingAgent.class)
                                           .chatModel(model)
                                           .build();

        var restaurantServing = AgenticServices.agentBuilder(RestaurantServingAgent.class)
                                               .chatModel(model)
                                               .build();

        var mealPlan = AgenticServices.agentBuilder(MealPlanAgent.class)
                                      .chatModel(model)
                                      .build();

        UntypedAgent planner = AgenticServices.plannerBuilder()
                                              .subAgents(
                                                      durationExtractor,
                                                      cook,
                                                      casualServing,
                                                      restaurantServing,
                                                      mealPlan
                                              )
                                              .outputKey("mealPlan")
                                              .planner(GoalOrientedPlanner::new)
                                              .build();

        System.out.println(planner.invoke(Map.of(
                "request", "A customer wants a meal that can be prepared in 10 minutes."
        )));

        System.out.println();

        // A supplied duration lets the planner skip duration extraction.
        System.out.println(planner.invoke(Map.of(
                "duration", 5
        )));

        System.out.println();

        // A supplied recipe lets the planner skip recipe generation.
        System.out.println(planner.invoke(Map.of(
                "recipe", "Tomato cheese toast. Cooking time: 8 minutes. Ingredients: bread, tomato, cheese. Steps: Put sliced tomato and cheese on bread; toast in a pan until the cheese melts."
        )));
    }
}