#include <stdio.h>
#include <stdlib.h>
 
void repeat(int rep, char c)
{
   int i;
   for (i = 0; i < rep; i++)
      putchar(c);
}

void repeatv(int rep){
	int i;
	 for (i = 1; i <=rep; i++){
	 	if(i==1||i==rep){
	 		printf("*");
	 	}
	 	else
	 		printf(" ");
	 }
}

void rombo(int l){
 int i;
 
   for (i = 1; i < l * 2; i += 2){ /* 1, 3, 5, 7, 9 */
      repeat((l - 1) - i/2, ' ');
      repeatv(i);
      repeat(((l*2)-1)-i,' ');
      repeat(i, '*');
      putchar('\n');
   }
 
  for (i -= 4; i > 0; i -= 2){ /* 7, 5, 3, 1 */
   		repeat((l - 1) - i/2, ' ');
      repeatv(i);
      repeat(((l*2) - 1) - i, ' ');
      repeat(i, '*');
      putchar('\n');
   }
}

int main(void)
{
	int n;
	printf("Numero del 6 al 48:\t");
	scanf("%d", &n);
	n=n/2;
  	rombo((n+1)/2);
   return 0;
}
