# Works with GPT-3.5, GPT-4
from langchain_openai import ChatOpenAI
from dotenv import load_dotenv
import util

model = ChatOpenAI(model='gpt-4', temperature=1.5, max_completion_tokens=10)

result = model.invoke("Write a 5 line poem on cricket")

print(result.content)
