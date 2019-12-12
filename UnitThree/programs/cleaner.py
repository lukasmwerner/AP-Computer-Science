import glob
import os

files = glob.glob("*.class")
for file in files:
    os.remove(file)