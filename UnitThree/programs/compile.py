import os
import glob
import sys
import hashlib
import pickle

hashr = hashlib.md5()

files = glob.glob("*.java")

fileBase = pickle.load(open("DATABASE_COMPILE.pk", "rb"))
newHashes = []

for file in files:
    with open(file, 'rb') as f:
        content = f.read()
        hashr.update(content)
        newHashes.append(hashr.hexdigest())


for file in files:
    with open(file, 'rb') as f:
        content = f.read()
        hashr.update(content)

        hashVal = hashr.hexdigest()
        
        if hashVal not in fileBase:
            os.system("javac " + file)
try:
    if len(sys.argv) >= 1:
        className = sys.argv[1].replace(".class", "").replace(".\\", "").replace(".java", "")
        print("[PYTHON] RUNNING: " + className)
        os.system("java " + className)
except IndexError as e:
    pass


pickle.dump(newHashes, open("DATABASE_COMPILE.pk", "wb"))