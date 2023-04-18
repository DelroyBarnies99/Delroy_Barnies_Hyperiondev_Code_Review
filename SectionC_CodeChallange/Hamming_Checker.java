public class Hamming_Checker {

	public static void main(String[] args) {

		System.out.println(hamming_checker("0100100100010010"));
		System.out.println(hamming_checker("0011011010100110"));
		System.out.println(hamming_checker("0010101011111111"));
	}

	// takes a hamming block and checks if there are any errors.
	// returns the fixed code if there are errors.
	public static String hamming_checker(String block) {

		// splits the string block into a string array
		String[] block_strings = block.split("");
		int[] block_int = new int[block_strings.length];

		// parses each bit from a string into a int and adds them to a new int array.
		for (int i = 0; i < block_strings.length; i++) {
			block_int[i] = Integer.parseInt(block_strings[i]);
		}

		int first_region = 0;
		int sum = 0;

		// gets the sum of all "1s" in the first region.
		for (int i = 1; i < block_int.length; i++) {

			if (i % 2 != 0) {
				if (block_int[i] == 1) {
					sum += 1;

				}
			}
		}

		first_region = sum % 2;
		int second_region = 0;
		sum = 0;

		// gets the sum of all "1s" in the second region.
		for (int i = 1; i < block_int.length; i++) {

			if (i % 2 == 0 && i % 4 != 0) {
				if (block_int[i] == 1) {
					sum += 1;
				}
				if (block_int[i + 1] == 1) {
					sum += 1;
				}
			}
		}

		second_region = sum % 2;
		int third_region = 0;
		sum = 0;

		// gets the sum of all "1s" in the third region.
		for (int i = 1; i < block_int.length; i++) {

			if (i % 4 == 0 && i % 8 != 0) {
				if (block_int[i] == 1) {
					sum += 1;
				}
				if (block_int[i + 1] == 1) {
					sum += 1;
				}
				if (block_int[i + 2] == 1) {
					sum += 1;
				}
				if (block_int[i + 3] == 1) {
					sum += 1;
				}
			}
		}

		third_region = sum % 2;
		int forth_region = 0;
		sum = 0;

		// gets the sum of all "1s" in the forth region.
		for (int i = 1; i < block_int.length; i++) {

			if (i > 7) {
				if (block_int[i] == 1) {
					sum += 1;
				}
			}
		}

		forth_region += sum % 2;

		// the index of the corrupted bit in binary in a string array.
		String[] binary_code = { Integer.toString(forth_region), Integer.toString(third_region),
				Integer.toString(second_region), Integer.toString(first_region) };

		// joins the array to a single string.
		String binary = String.join("", binary_code);

		// converts the binary to decimal to get the index of the corrupted bit.
		int bit_index = Integer.parseInt(binary, 2);

		// if the bit index is 0 it means there are no errors and the same code will be
		// returned.
		// if the bit index is greater than 0 it replaces the bit at that index by a 0
		// or 1.
		// returns the fixed code.
		if (bit_index == 0) {
			return block;

		} else if (block_strings[bit_index] == "0") {
			block_strings[bit_index] = "1";
			return String.join("", block_strings);

		} else {
			block_strings[bit_index] = "0";
			return String.join("", block_strings);
		}

	}

}
