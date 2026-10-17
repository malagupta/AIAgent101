package com.gupta._3_structured_recipe;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.google.genai.GoogleGenAiChatModel;
public final class ModelConfig {
    private ModelConfig() {
    }

    public static ChatModel create() {

        String key = System.getenv("GEMINI_API_KEY");
        String model = System.getenv("GEMINI_MODEL");

        if (key == null || key.isBlank()) throw new IllegalStateException("Set GEMINI_API_KEY in your environment or IDE run configuration.");
        if (model == null || model.isBlank()) throw new IllegalStateException("Set GEMINI_MODEL to a Gemini model available to your account.");

        return GoogleGenAiChatModel.builder()
                                   .apiKey(key)
                                   .modelName(model)
                                   .build();
    }
}
