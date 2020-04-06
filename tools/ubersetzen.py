import sys
import os
import translate
from pprint import pprint
ubersetzer = translate.Translator(to_lang="en", from_lang="de")

# TODO
# * NLTK wort seperazion
# * Nur das Deustch ubersetzen 
# * autoFuller worter so das context die variablen nicht verendert

try:

    if os.path.exists(sys.argv[1]):
        with open(sys.argv[1]) as ff:
            dasText = ff.readlines()
        for eineLinie in dasText:
            ubersetzed = ubersetzer.translate(eineLinie)
            print(ubersetzed)
except Exception as e:
    print(e)