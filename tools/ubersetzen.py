import sys
import os
import translate
from pprint import pprint
ubersetzer = translate.Translator(to_lang="en", from_lang="de")

try:

    if os.path.exists(sys.argv[1]):
        with open(sys.argv[1]) as ff:
            dasText = ff.readlines()
        pprint(dasText)
        ubersetzed = ubersetzer.translate(dasText)
        for sache in ubersetzed:
            print(sache)
except Exception as e:
    print(e)