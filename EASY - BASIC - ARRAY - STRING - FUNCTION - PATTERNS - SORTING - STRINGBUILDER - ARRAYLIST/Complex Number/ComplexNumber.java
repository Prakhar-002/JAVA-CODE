public class ComplexNumber {

      // complex number add , diff ,multi
      public static class Complex {
            int real;
            int img;

            public Complex(int real, int img) {
                  this.real = real;
                  this.img = img;
            }

            public void print(int real, int img) {
                  if (img >= 0) {
                        System.out.println(real + " + i" + img);
                  } else {
                        System.out.println(real + " - i" + Math.abs(img));
                  }
            }

            public void add(int real, int img) {
                  this.real += real;
                  this.img += img;

                  print(this.real, this.img);
            }

            public void sub(int real, int img) {
                  this.real -= real;
                  this.img -= img;

                  print(this.real, this.img);
            }

            public void mul(int real, int img) {
                  // (a + ib) (c + id) = (ac - bd) + i(ad + bc)
                  this.real = (this.real * real) - (this.img * img);
                  this.img = (this.real * img) - (this.img * real);

                  print(this.real, this.img);
            }
      }

      public static void main(String[] args) {
            Complex com = new Complex(5, 2);
            com.add(2, 4);
            com.sub(4, 6);
            com.sub(4, 6);
            com.mul(4, 7);
      }

      // ? Output
      //  1.
      //     7 + i6
      //     3 + i0
      //     -1 - i6
      //     38 + i290
}