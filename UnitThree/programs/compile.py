import os
import glob
import sys

files = glob.glob("*.java")

for file in files:
    os.system("javac " + file)
try:
    if len(sys.argv) >= 1:
        className = sys.argv[1].replace(".class", "").replace(".\\", "").replace(".java", "")
        print("[PYTHON] RUNNING: " + className)
        os.system("java " + className)
except IndexError as e:
    pass
    