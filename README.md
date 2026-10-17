- _1_first_request (Inference): Sends a recipe request to a chat model and prints its response, establishing the baseline before introducing tools or agents.
  
- _2_recipe_tool (Tool calling): Exposes a local recipe catalogue through a Java @Tool method and instructs the model to consult it before recommending a dish.

- _3_structured_recipe (Structured output): Combines menu-tool access with a typed Recipe record instead of a plain-text response.

- _4_meal_agent (Agent definition): Defines a LangChain4j @Agent that produces a structured recipe from supplied ingredients within a single-agent sequence.

- _5_serving_workflow (Sequential orchestration): Chains recipe generation and serving advice, passing the first agent’s output to the second.

- _6_parallel_options (Parallel orchestration): Generates a recipe, then runs casual and restaurant-style serving agents concurrently and collects their outputs.

- _7_goal_planner (Goal-oriented planning): Uses declared agent inputs and outputs to plan towards a meal plan, skipping prerequisite steps when their results are already supplied.
