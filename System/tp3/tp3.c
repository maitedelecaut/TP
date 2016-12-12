#include <stdio.h>

int mon_strlen(char s[]){
  int i=0;
  while(s[i]!='\0'){
    i = i+1;
  }
  return i;
}

int mon_strlen1(const char *s){
  int i = 0;
  while(*s!='\0'){
    i++;
    s++;
  }
  return i;
}

int mon_strcmp(const char * s1, const char * s2){
  while(*s1!='\0' || *s2!='\0'){
    if(*s1<*s2){
      return -1;
    }
    else if(*s1>*s2){
      return 1;
    }
    s1++;
    s2++;
    
    }
  if(s1 == '\0'){
    return -1;
  }
  else if(s2=='\0'){
    return 1;
  }
  else{
    return 0;
  }
}

int mon_strncmp(const char * s1, const char * s2, int n){
  int i = 0;
  while((*s1!='\0' || *s2!='\0') && i<n){
    if(*s1<*s2){
      return -1;
    }
    else if(*s1>*s2){
      return 1;
    }
    s1++;
    s2++;
    i++;
    
    }
  if(s1 == '\0'){
    return -1;
  }
  else if(s2=='\0'){
    return 1;
  }
  else{
    return 0;
  }
}

char *mon_strcat(char *s1, const char *s2){
  char *tmp = s1;
  while(*tmp != '\0'){
    tmp++;
  }
  while(*s2 != '\0'){
    *(tmp) = *(s2);
    s2++;
    tmp++;
  }
  *(tmp) = '\0';
  return s1;
}

char *mon_strchr(char *s, char c){
  while(*s != '\0'){
    if(*s == c){
      return s;
    }
    s++;
  }
  return NULL;
}

char *mon_strstr(char *haystack, char *needle){

	char *pointRes;

	while(*haystack != '\0'){
		if(mon_strncmp(haystack, needle, mon_strlen1(needle)) == 0){

			pointRes = haystack;
			
			return pointRes;
		}

		++haystack;

	}

	return NULL;

}


void main(void){
  char s [50];
  s[0] = 'a';
  s[1] = 'a';
  s[2] = '\0';
  
  char s1[] = "bcb";
  char s2[] = "bcc";
  //printf("%d\n", mon_strlen(s));
  char *p = s;
  char *l = s1;
  char *m = s2;
  //printf("%d\n", mon_strlen(p));
  //printf("%d\n", mon_strcmp(p,p));
  //printf("%d\n", mon_strcmp(p,l));
  //printf("%d\n", mon_strcmp(l,m));
  //printf("%d\n", mon_strncmp(l,m,2));

  //printf("%s\n", mon_strcat(p,l));
  printf("%s\n", mon_strchr(l,'c'));
  //printf("%s\n", mon_strchr(l,'a')); creer fonction pour si retourne null affihcer null
  
}
