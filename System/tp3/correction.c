#include <stdio.h>

int mon_strlen( char s []){
	int i=0;
	while (s[i] != '\0'){
		i++;
	}
	return i;
}

int mon_strlen2(const char *s){

	int cpt = 0;

	while(*s != '\0'){
		++cpt;
		++s;
	}

	return cpt;
}

int mon_strcmp(const char * s1, const char * s2){
	int i = 0;
	int x = 0;
	int y = 0;
	printf("%s\n",s1);
	while(*(s1+x) != '\0' && *(s2+y) !='\0'){
		
		if(*(s1+x) < *(s2+y))
			return -(i+1);
		else if(*(s1+x) > *(s2+y))
			return i+1;
		
		i++;
		x++;
		y++;
	}
	if(*(s1+x) == '\0' && *(s2+y) != '\0')
		return -(i+1);
	else if(*(s2+y) == '\0' && *(s1+x) != '\0')
		return i+1;
	return 0;
}

int mon_strncmp(const char * s1, const char * s2, int n){
	int cpt = n;

	while(*s1 != '\0' && *s2 != '\0' && cpt > 0){

		if(*s1 == *s2){
			++s1;
			++s2;
			--cpt;
		} else if(*s1 > *s2){
			return 1; 
		} else {
			return -1;
		}

	}

	return 0;

}

char *mon_strcat(char *s1, const char *s2){
	int i = 0;
	int j = 0;
	while(*(s1+i) != '\0'){
		i++;
	}
	while(*(s2+j) != '\0'){
		*(s1+i) = *(s2+j);
		j++;
		i++;
	}
	*(s1+i) = '\0';
	return s1;
}

char *mon_strchr(char *s, char c){
	int i =0;
	while (*(s+i) != '\0'){
		
		if(*(s+i) == c)
			return (s+i);
		i++;
	}
	return NULL;
}

char *mon_strstr(char *haystack, char *needle){

	char *pointRes;

	while(*haystack != '\0'){
		if(mon_strncmp(haystack, needle, mon_strlen2(needle)) == 0){

			pointRes = haystack;
			
			return pointRes;
		}

		++haystack;

	}

	return NULL;

}

int  main(){
	char s[] = "abcd";
	char *p = "abcd";
	printf("%s : %d\n",s , mon_strlen(s));
	printf("%s : %d\n",p ,mon_strlen2(p));
	
	char *p1 = "aaabbbccc";
	char *p2 = "aaabbbzzz";
	int n = 10;
	printf("%s vs %s : %d\n",p1, p2, mon_strcmp(p1,p2));
	printf("%s vs %s jusque %d: %d\n",p1, p2,n ,mon_strncmp(p1,p2,n));
	
	char s1[20];
	s1[0] = 'l';
	s1[1] = 'a';
	s1[2] = 'm';
	s1[3] = '\0';
	char *s2 = "a blanc";
	printf("%s + %s",s1, s2);
	printf(" = %s \n", mon_strcat(s1,s2));
	
	char c = 'r';
	char *s3 = "azerty";
	printf("%c dans %s  :  ",c,s3);
	char *s4 = mon_strchr(s3,c);
	printf("%s\n",s4);
	
	char *haystack = "ManuelValsEstUnCon, ManuelValsSeraUnCon";
	char *needle = "ValsSe";
	
	char *r = mon_strstr(haystack, needle);
	printf("resultat : %s\n", r);
	
	return 0;
}