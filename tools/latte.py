import os
import glob
import sys
import ntpath

if len(sys.argv) > 1 and (".javap" in sys.argv[1] or ".jpy" in sys.argv[1] or ".latte" in sys.argv[1] or ".lt" in sys.argv[1]):
    print("                              ")
    print("         `` `` `` `` ``       ")
    print("       /o//+//+//+//+//s.     ")
    print("     h+d+++++++++++++++syy/   ")
    print(" .++++`dssooosssssoooosyo++   ")
    print(":s:o+d.d///////////////so++   ")
    print("d.h` y-h+//////////////y+o:   ")
    print("y:s/ :s:h/////////////oy-h    ")
    print("`o++++o-:yo/////////+/o:y.    ")
    print("  `:++++o+/ossooosss+/o+      ")
    print("         `/++++oo++++:        ")
    print(" .++++++++++++ooo++++++++++++/")
    print("  :y++++++++++++++++++++++++y`")
    print("    ````````````````````````  ")
    print("THE LATTE COMPILER".center(30, " "))
    print()



    for zz in range(1, len(sys.argv)):
        fileName = sys.argv[zz]
        if sys.platform == "darwin" or sys.platform.startswith("linux"):
            className = os.path.basename(sys.argv[zz]).split(".")[0] 
            fileNameClean = os.path.basename(sys.argv[zz])
        else:
            className = ntpath.basename(sys.argv[zz]).split(".")[0]
            fileNameClean = ntpath.basename(sys.argv[zz])
        lines = []

        print("[LATTE COMPILER] RUNNING TRANSPILE")
        with open(fileName, 'r') as f:
            content = f.readlines()
            for line in content:
                lines.append(line)
        for i in range(len(lines)):
            if "main" in lines[i]:
                lines.insert(i, "public class " + className + "{ \n")
                lines.insert(len(lines)-1, "}")
                break

        

        x = 0
        for line in lines:
            i = 0
            oLine = list(line)
            for char in line:
                if char == "\n" and "{" not in line and "}" not in line and "if" not in line and "for" not in line and not line[:-1].endswith(",") and not line[:-1].endswith("\""):
                    oLine[i] = ";\n"
                i+=1
            lines[x] = "".join(oLine)
            lines[x] = lines[x].replace("print", "System.out.println")

            x+=1
        with open(fileName.replace(".javap", ".java").replace(".jpy", ".java").replace(".latte", ".java").replace(".lt", ".java"), 'w') as f:
            for line in lines:
                f.write(line)
        print("[LATTE COMPILER] RUNNING COMPILE")
        os.chdir( (sys.argv[zz]).replace(fileNameClean, "") )
        os.system("javac " + fileNameClean.replace(".javap", ".java").replace(".jpy", ".java").replace(".latte", ".java").replace(".lt", ".java"))
        print("[LATTE COMPILER] RUNNING JAVA CLASS")
        os.system("java " + fileNameClean.replace(".javap", "").replace(".jpy", "").replace(".\\", "").replace(".latte", ".java").replace(".lt", ".java"))
else:
    print("[LATTE COMPILER] NO FILE PROVIDED!!!")