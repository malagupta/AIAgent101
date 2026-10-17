package com.gupta._7_goal_planner;

import dev.langchain4j.agentic.Agent;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;

public interface DurationExtractorAgent {
    @UserMessage("""
            Extract the cooking time limit from this customer request:
            {{request}}

            Return only the number of minutes as an integer.
            If no duration is mentioned, return 10.
            """)

    @Agent(description = "Extracts the requested cooking duration in minutes from a customer request", outputKey = "duration")
    int extract(@V("request") String request);
}