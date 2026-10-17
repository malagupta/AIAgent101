package com.gupta._7_goal_planner;

import dev.langchain4j.agentic.Agent;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;

public interface CasualServingAgent {
    @UserMessage("""
            Recipe:
            {{recipe}}

            Suggest a simple home-style way to serve this dish.
            Recommend suitable everyday tableware such as a plate, bowl, small bowl, or platter.
            Keep it practical and casual.

            Return only:
            Casual serving:
            <your recommendation with one short reason>
            """)

    @Agent(description = "Suggests a casual home-style serving option for a recipe", outputKey = "casualServing")
    String suggest(@V("recipe") String recipe);
}