public class ChemSim {

  public static void main(String[] args) {

    Molecule molecule1 = new Molecule();

    System.out.println(molecule1);

    // 1.) Add and print a new Molecule made up of 1 or 2 elements
    //  Ideas: https://chemistry.boisestate.edu/richardbanks/inorganic/common_names.htm

    Element sodium = new Element(11, 11, 11, "Sodium", "Na", 1);
    Element chlorine = new Element(17, 18, 17, "Chlorine", "Cl", 1);

    Molecule tableSalt = new Molecule(sodium, chlorine, "Sodium chloride");

    System.out.println(tableSalt);

    // Constructor looks like
    // Protons, neutrons, electrons, name, symbol, quantity
    

    // 2.) Add and print a second new Molecule made up of 2 or 3 elements

    Element carbon = new Element(6, 6, 6, "Carbon", "C", 6);
    Element hydrogen = new Element(1, 1, 1, "Hydrogen", "H", 12);
    Element oxygen = new Element(8, 8, 8, "Oxygen", "O", 6);

    Molecule glucose = new Molecule(carbon, hydrogen, oxygen, "Glucose");
    System.out.println(glucose);

  }

}
