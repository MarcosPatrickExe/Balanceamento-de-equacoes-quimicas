package comOO;
import java.util.Scanner;

//Array { [0] nÂ°de molÃ©culas, [1]nÂ°de diferentes elementos [0][1] -> nÂ° de atomos; [0][2]->simbolo do elemento; }

class Principal {
	public static void main(String[] args) {
		boolean novaRodada= false;
		boolean parar=false;
		int numRodada=1;
		
		Scanner ler = new Scanner(System.in);
		System.out.println("Quantas moléculas existem no primeiro membro da equação?");
		int quantMol = ler.nextInt();
		
		String mol[][][] = new String[quantMol][][];
		int quantEle;

		double[] indices1 = new double[quantMol];
		for(int v=0; v<indices1.length;v++) { indices1[v]=1.0;}

		int c=0;
		//char[] simE;
		while(c<mol.length) {
			System.out.println("Há quantos tipos de elementos químicos na molécula "+(c+1)+" do primeiro membro?");
			quantEle = ler.nextInt();
			
			mol[c] = new String[quantEle][2]; 
					for(int j=0;j<mol[c].length; j++) {
						String simbEle;
						int quantAto;
						
						Scanner s = new Scanner(System.in);
						System.out.println("Digite o símbolo do "+(j+1)+"° elemento  na "+(c+1)+"° molécula do primeiro membro...");
						 simbEle = s.nextLine();
						System.out.println();
						
						mol[c][j][0]=simbEle;
						
						System.out.println("Qual a quantidade de átomos do "+(j+1)+"° elemento?");
						 quantAto = ler.nextInt();
						
						mol[c][j][1]=String.valueOf(quantAto); 
					} 
			c++;
		}


		Scanner ler2 = new Scanner(System.in);
		System.out.println("\n Quantas moléculas existem no segundo membro da equação?");
		int quantMol2 = ler2.nextInt();
		String mol2[][][] = new String[quantMol2][][];

		double indices2[] = new double[quantMol2];
		for(int v=0; v<indices2.length;v++) { indices2[v]=1.0;}

		c=0;
		while(c<mol2.length) {
			System.out.println("Há quantos tipos de elementos químicos na molécula "+(c+1)+" do segundo membro?");
			quantEle = ler2.nextInt();

			mol2[c] = new String[quantEle][2]; 
			//indices2[c] = mol2[c-1][quantEle2+1];

			for(int j=0;j<mol2[c].length; j++) {
				String simbEle;
				int quantAto;
				
				Scanner s = new Scanner(System.in);
				System.out.println("Digite o símbolo do "+(j+1)+"° elemento na "+(c+1)+"° molécula...");
				 simbEle = s.nextLine();
				System.out.println();
				
				mol2[c][j][0]=simbEle;
		
				
				System.out.println("Qual a quantidade de átomos do "+(j+1)+"° elemento?");
				 quantAto = ler2.nextInt();
				
				mol2[c][j][1]=String.valueOf(quantAto); 
			} 
			c++;
		}

		/*System.out.println("Digite agora a equaÃ§Ã£o completa. PS: utilize o sinal de + para separar as molÃ©culas.");
		System.out.println("Digite agora a equaÃ§Ã£o completa. PS: utilize o sinal de + para separar as molÃ©culas.");
		String equacao = ler.nextLine();  */

        boolean rodar=true;
        for(int i=0; i<mol.length; i++) {
        	for(int h=0; h<mol[i].length; h++) {
        		
        	int p = i;
            while(rodar==true) {
        		if(p+1<mol.length) {
        		int na, nb;
        		double indice1, indice2;
        		
        		   	for(int f=0; f<mol[p+1].length; f++) {
        		   		 
        		   		if(mol[i][h][0].equals(mol[p+1][f][0])) {
        		   			na = Integer.parseInt(mol[i][h][1]);
        		   			nb = Integer.parseInt(mol[p+1][f][1]);
        		   			indice1=indices1[i];
        		   			indice2=indices1[p+1];
        		   			
        		   			if((indice1*na) == (indice2*nb)) {
        		   				indices1[i]=indice1*na;
        		   				indices1[p+1]=indice2*nb;
        		   			}else {
        		   			   while(indice1*na != indice2*nb) {
        		   				    if(indice1*na > indice2*nb) {
        		   				    	
        		   				      if(novaRodada==true) {
      		   				           double num1 = indice1*na;
         		   				   	   double num2 = indice2*nb;
      		   				    	       
      		   				   		   for(int a=2;a<50;a++) {
      		   				  		     if(num1 == num2*a) {
      		   			    		    	 indices1[p+i] = num2*a;
      		   			    		    	 indice2 = num2*a;
      		   			    		 		 a=50;
      		   			    		 		 parar=true;
      		   				    		     }
      		   				    	       }    	 
      		   			    	     }else {
        		   				    	
        		   				    	if(nb==1) {
        		   				    		indice2=na;
        		   				    		indices1[p+1]=na;
        		   				    	}else {	
        		   				    	  for(int g=1; g<100; g++) {
        		   				    		 if(na==(g*nb)) {
        		   				    			 indice2=g;
        		   				    			// indices1[i]=1;
        		   				    			 indices1[p+1]=g;
        		   				    			 break;
        		   				    		 } 		 
        		   				    	 }}
        		   				    	 
        		   				    	if(nb!=1 && indice2==1.0) {
        		   				    		double res = (indice1*na) / (indice2*nb);
        		   				    		int mult =2;
        		   				    		if((0<res && res<1) || (1<res && res<2) || (2<res && res<3) || (3<res && res<4) 
        		   				    			|| (4<res && res<5) || (5<res && res<6)) {
        		   				    			for(int y=2; y<50; y++) {
        		   				    				double res2 = res*y;
        		   				    				
        		   				    				if(!(0<res2 && res2<1) || (1<res2 && res2<2) || (2<res2 && res2<3) || (3<res2 && res2<4) 
        	        		   				    			|| (4<res2 && res2<5) || (5<res2 && res2<6)) {
        		   				    					mult = y;
        		   				    					res = res2;
        		   				    					y=50;
        		   				    					indice1 *= mult;
        	        		   				    		indice2 = res;
        	        		   				    		indices1[i] *= mult;
        	        		   				    		indices1[p+1]=res;
        		   				    				}
        		   				    			}
        		   				    			
        		   				    		}else {
        		   				    			indice2 = res;
          		   				    		     //indice2 *= mult;
          		   				    		     indices2[p+1] = res;
          		   				    		    // indices1[p+1] *= mult;
        		   				    		  }
        		   				    	}
        		   				      }
        		   				    	
        		   				    	
        		   				    }else if(indice1*na < indice2*nb) {
        		   				      if(novaRodada==true) {
      		   				           double num1 = indice1*na;
         		   				   	   double num2 = indice2*nb;
      		   				    	       
      		   				   		   for(int a=2;a<50;a++) {
      		   				   		     if(num1*a == num2) {
      		   			    		    	 indices1[i] = num1*a;
      		   			    		    	 indice1 = num1*a;
      		   			    		 		 a=50;
      		   			    		 		 parar=true;
      		   			    		     }
      		   			    	        }    	 
      					    	      }else{
        		   				    	
        		   				    	if(na==1) {
        		   				    		indice1=nb;
        		   				    		indices1[i]=nb;
        		   				    	}else {	
        		   				    	  for(int g=1; g<100; g++) {
        		   				    		 if(nb==(g*na)) {
        		   				    			 indice1=g;
        		   				    			// indices1[i]=1;
        		   				    			 indices1[i]=g;
        		   				    			 System.out.println("\n --break ativado-- ");
        		   				    			 break;
        		   				    		 } 		 
        		   				    	 }}
        		   				    	 
        		   				    	if(na!=1 && indice1==1.0) {
        		   				    		double res = (indice2*nb) / (indice1*na);
        		   				    		int mult =2;
        		   				    		if((0<res && res<1) || (1<res && res<2) || (2<res && res<3) || (3<res && res<4) 
        		   				    			|| (4<res && res<5) || (5<res && res<6)) {
        		   				    			for(int y=2; y<50; y++) {
        		   				    				double res2 = res*y;
        		   				    				
        		   				    				if(!(0<res2 && res2<1) || (1<res2 && res2<2) || (2<res2 && res2<3) || (3<res2 && res2<4) 
        	        		   				    			|| (4<res2 && res2<5) || (5<res2 && res2<6)) {
        		   				    					res = res2;
        		   				    					mult = y;
        		   				    				    y=50;	
        		   				    				    indice1 = res;
        	        		   				    		indice2 *= mult;
        	        		   				    		indices1[i] = res;
        	        		   				    		indices1[p+1] *= mult;
        		   				    				}
        		   				    			}
        		   				    		
        		   				    		}else {
        		   				    		 indice1 = res;
       		   				    		     //indice2 *= mult;
       		   				    		     indices1[i] = res;
       		   				    		    // indices1[p+1] *= mult;
        		   				    		  }
        		   				    	}
        		   				      }
        		   				    }
        		   			   }			
        		   			}
        		   		}
        		   	}

        		}else {rodar = false;}
        		p+=1;
        	}
            
 //a partir daqui será a verificação do segundo membro: -----------------------------------------------------------------------------------
            
            boolean rodar2=true;
            while(rodar2==true) {
        		int na, nb;
        		double indice1, indice2;
        		
        		for(int f=0; f<mol2.length; f++) {
        		   	for(int d=0; d<mol2[f].length; d++) {
        		   		 
        		   		if(mol[i][h][0].equals(mol2[f][d][0])) {
        		   			na = Integer.parseInt(mol[i][h][1]);
        		   			nb = Integer.parseInt(mol2[f][d][1]);
        		   			indice1=indices1[i];
        		   			indice2=indices2[f];
        		   			
        		   			if((indice1*na) == (indice2*nb)) {
        		   				System.out.println("verificando indice1(3) ="+indice1+" indice2(2) ="+indice2);
        		   				System.out.println("verificando na="+na+" nb ="+nb);
        		   				continue;
        		   			}else {
        		   			   while(indice1*na != indice2*nb) {
        		   				    if(indice1*na > indice2*nb) {
        		   				    	
        		   				    	if(novaRodada==true) {
       		   				    	       double num1 = indice1*na;
          		   				    	   double num2 = indice2*nb;
       		   				    	       
       		   				    		   for(int a=2;a<50;a++) {
       		   				    		     if(num1 == num2*a) {
       		   				    		    	 indices2[f] = num2*a;
       		   				    		    	 indice2 = num2*a;
       		   				    		 		 a=50;
       		   				    		 		 parar=true;
       		   				    		     }
       		   				    	       }    	 
       		   				    	     }else { 
       		   				    	    	 
        		   				    	if(nb==1) {
        		   				    		indice2=na;
        		   				    		indices2[f]=na;
        		   				    		
        		   				    	}else {	
        		   				    	  for(int g=1; g<100; g++) {
        		   				    		 if(na==(g*nb)) {
        		   				    			 indice2=g;
        		   				    			 //indices1[i]=1;
        		   				    			 indices2[f]=g;
        		   				    			 break;
        		   				    		 } 		 
        		   				    	 }}
        		   				    	 
        		   				    	if(nb!=1 && indice2==1.0) {
        		   				    		double res = (indice1*na) / (indice2*nb);
        		   				    		int mult =2;
        		   				    		if((0<res && res<1) || (1<res && res<2) || (2<res && res<3) || (3<res && res<4) 
        		   				    			|| (4<res && res<5) || (5<res && res<6)) {
        		   				    			for(int y=2; y<50; y++) {
        		   				    				double res2 = res*y;
        		   				    				if(!(0<res2 && res2<1) || (1<res2 && res2<2) || (2<res2 && res2<3) || (3<res2 && res2<4) 
        	        		   				    			|| (4<res2 && res2<5) || (5<res2 && res2<6)) {
        		   				    					res = res2;
        		   				    					mult = y;
        		   				    					y=50;
        		   				    					indice1 *= mult;
        	        		   				    		indice2 = res;
        	        		   				    		indices1[i] *= mult;
        	        		   				    		indices2[f]=res;
        		   				    				}
        		   				    			}
        		   				    		}else {
            		   				    		indice2 = res;
            		   				    		System.out.println("indice = "+indice1);
            		   				    		//indice2 *= mult;
            		   				    		indices2[f] = res;
            		   				    		//indices2[f] *= mult; }
            		   				            }
        		   				    		
        		   				    	}
        		   				      }	
        		   				    	
        		   				    	
        		   				    	
        		   				    }else if(indice1*na < indice2*nb) {
        		   				    	if(novaRodada==true) {
      		   				    	       double num1 = indice1*na;
         		   				    	   double num2 = indice2*nb;
      		   				    	       
      		   				    		   for(int a=2;a<50;a++) {
      		   				    		     if((num1*a) == num2) {
      		   				    		    	 indices1[i] = num1*a;
      		   				    		    	 indice1 = num1*a;
      		   				    		 		 a=55;
      		   				    		 		 parar=true;
      		   				    		 	     System.out.println(indices1[i]);
      		   				    		     }
      		   				    		     System.out.println("a ="+a);
      		   				    	       }    	 
      		   				    	     }else {	
        		   				    	
        		   				    	if(na==1) {
        		   				    		indice1=nb;
        		   				    		indices1[i]=nb;
        		   				    	}else {	
        		   				    	  for(int g=1; g<100; g++) {
        		   				    		 if(nb==(g*na)) {
        		   				    			 indice1=g;
        		   				    			// indices1[i]=1;
        		   				    			 indices1[i]=g;
        		   				    			 System.out.println("\n --break ativado-- ");
        		   				    			// break;
        		   				    		 } 		 
        		   				    	 }}
        		   				    	 
        		   				    	if(na!=1 && indice1==1.0) {
        		   				    		//System.out.println("indice2 está com: "+indice2+"| nb="+nb+" | indice1="+indice1+" | na="+na);
        		   				    		double res = (indice2*nb) / (indice1*na);
        		   				    		
        		   				    		int mult;
        		   				    		if((0<res && res<1) || (1<res && res<2) || (2<res && res<3) || (3<res && res<4) 
        		   				    			|| (4<res && res<5) || (5<res && res<6)) {
        		   				    			for(int y=2; y<50; y++) {
        		   				    				double res2 = res*y;
        		   				    				
        		   				    				if(!( (0<res2 && res2<1) || (1<res2 && res2<2) || (2<res2 && res2<3) || (3<res2 && res2<4) 
        	        		   				    			|| (4<res2 && res2<5) || (5<res2 && res2<6) )) {
        		   				    					res = res2;
        		   				    					mult = y;
        		   				    					y=50;
        		   				    					indice1 = res;
        	        		   				    		indice2 *= mult;
        	        		   				    		indices1[i] = res;
        	        		   				    		indices2[f] *= mult; 
        		   				    				}
        		   				    			  }
        		   				    			
        		   				    		}else {
        		   				    		indice1 = res;
        		   				    		//System.out.println("indice deve ser numero natural, sendo: "+indice1);
        		   				    		//indice2 *= mult;
        		   				    		indices1[i] = res;
        		   				    		//indices2[f] *= mult; }
        		   				            }
        		   				         }
        		   				      }   	
        		   			   }			
        		   			}
        		   		 }
        		   		}	
           		   	  }} rodar2=false;
                   
            }
       
   }
       if((i==mol.length-1) & parar==false) { //if(i==(mol.length-1) && parar==false) {
    	   i=-1;
    	   numRodada++;
    	   novaRodada = true;
       }
  }
        
      //a partir daqui será a concatenação dos elementos da equação:
        String equacao1="";
        boolean ind=false;
        
        for(int t=0; t<mol.length; t++) {
      	  for(int r=0; r<mol[t].length; r++) {
      		  if(ind==false) {
      			  equacao1 += indices1[t]+""+mol[t][r][0]+"("+mol[t][r][1]+")";
      			  ind=true;
      		  }else {
      			  equacao1 += ""+mol[t][r][0]+"("+mol[t][r][1]+")";
      		  }
      		  
      	  }
      	  
      	  if(t<mol.length-1) {
      	    ind=false;
      	    equacao1 += " + ";
      	  }      	  
        }
        
        equacao1 += " --> ";
        
        String equacao2="";
        ind=false;
        for(int t=0; t<mol2.length; t++) {
      	  for(int r=0; r<mol2[t].length; r++) {
      		  if(ind==false) {
      			  equacao2 += indices2[t]+""+mol2[t][r][0]+"("+mol2[t][r][1]+")";
      			  ind=true;
      		  }else {
      			  equacao2 += ""+mol2[t][r][0]+"("+mol2[t][r][1]+")";
      		  }
      		  
      	  }
      	  
      	  if(t<mol2.length-1) {
      	    ind=false;
      	    equacao2 += " + ";
      	  }      	  
        }
        
        System.out.println("\n    "+equacao1+equacao2);
        System.out.println("total de balanceamentos feitos: "+numRodada);
 
}
}
