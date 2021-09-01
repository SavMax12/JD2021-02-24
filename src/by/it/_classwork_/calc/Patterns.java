package by.it._classwork_.calc;

interface Patterns {

    String OPERATION = "(?<=[^,(+*/=-])[+=*/-]";
    String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
    String VECTOR = "\\{" + SCALAR + "(," + SCALAR + ")*}";
    String MATRIX = "\\{" + VECTOR + "(," + VECTOR + ")*}";
//-4*{1,2,3,4.775,-8,-99}-{-1,2,3,-4}
}
