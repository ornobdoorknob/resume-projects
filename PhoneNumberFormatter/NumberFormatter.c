
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

bool valid(int number) {
  int central_office_code;
  if (number < 1000000 || number > 9999999) {
    printf("Number is not 7 digits long. ");
    return false;
  }
  central_office_code = number / 10000;
  if (central_office_code < 200 || central_office_code > 999) {
    return false;
  }
  return true;
}

int main() {
  int central_office_code;
  int subscriber;
  int number;
  while (true) {
    printf("Enter a 7-digit phone number (or 0 to exit): ");
    scanf("%d", &number);

    if (number == 0) {
        printf("Quit signal received.\n");
      break;
    }

    if (!valid(number)) {
      printf("Invalid phone number!\n");
      continue;
    }

    central_office_code = number / 10000 % 1000;
    subscriber = number % 10000;
    printf("The formatted phone number is %03d-%04d\n", central_office_code, subscriber);
  }

  return 0;
}


