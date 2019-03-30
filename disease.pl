go:-
write('Finish answer with (.)\n'),
write('Answer y==yes and n==no.\n'),
hypothesis(Disease),
explanation(Disease),
write('I believe you have:'),
write(Disease),
nl,
write('TAKE CARE'),
nl,
undo.

/*Hypothesis that should be tested*/
hypothesis(cold):- cold, !.
hypothesis(malaria):- malaria, !.
hypothesis(tb):- tb, !.
hypothesis(hiv):- hiv, !.
hypothesis(arthritis):- arthritis, !.
hypothesis(unknown). /*no diagnosis*/

 cold:-
 verify('Headache'),
 verify('Runny nose'),
 verify('Sneezing'),
 verify('Sore throat').

 malaria:-
 verify('Chills'),
 verify('Cough'),
 verify('Anemia'),
 verify('Nausea'),
 verify('Profuse sweating'),
 verify('Adbominal pain'),
 verify('Weakness'),
 verify('Headache'),
 verify('Joint pain').

 tb:-
 verify('Coughing blood'),
 verify('Chest pain'),
 verify('Loss of appetite'),
 verify('Night sweats'),
 verify('Fever'),
 verify('Fatigue'),
 verify('Weight loss').

 hiv:-
 verify('Fever'),
 verify('Weakness'),
 verify('Muscle pain'),
 verify('Joint pain'),
 verify('Groin inflamation'),
 verify('Sore throat'),
 verify('Nasal conjestion').

 arthritis:-
 verify('Pain in joints'),
 verify('Stiffness in joints'),
 verify('Fatigue').
 
 explanation(cold):-
 write('Advices and Sugestions:'),
 nl,
 write('1: Tynenol/teb'),
 nl,
 write('2. Panadol/tab'),
 nl,
 write('3. Nasal spray'),
 nl,
 write('Please wear warm clothes Because'),
 nl.

 explanation(malaria):-
 write('Advices and Sugestions:'),
 nl,
 write('1: Aralen/tab'),
 nl,
 write('2: Qualaquin/tab'),
 nl,
 write('3: Plaquenil/tab'),
 nl,
 write('4: Mefloquine'),
 nl,
 write('Please do not sleep in open air and cover your full skin Because'),
 nl.

 explanation(tb):-
 write('Advice and Sugestions:'),
 nl,
 write('1: Isoniazid'),
 nl,
 write('2: Rifampin'),
 nl,
 write('3: Pyrazinamide'),
 nl,
 write('4: Streptomyan'),
 nl,
 write('Please go for reqular screening and avoid crowded places Because'),
 nl.
 
 explanation(hiv):-
 write('Advice and Sugestions:'),
 nl,
 write('Multiclass:'),
 nl,
 write('	1: Abacavir(Triuma)'),
 nl,
 write('	2: Dolutegranis(Julica)'),
 nl,
 write('	3: Elvitegravir(Stribiid)'),
 nl,
 write('Intergrate Inhibitor:'),
 nl,
 write('	1: Dolutegravic(Tivicay)'),
 nl,
 write('	2: Elvitegravic(Vitekta)'),
 write('NRTIS'),
 nl,
 write('	1: Abacavir(Ziagens)'),
 nl,
 write('	2: Lamivudine(Epivir)'),
 nl,
 write('Eat plenty of fruits to'),
 nl.

 explanation(arthritis):-
 nl,
 write('Testing1'),
 nl,
 write('Testing2'),
 nl.

 askQuestion(Question):-
 write('Does the patient have the following symptoms:'),
 write(Question),
 write('?'),
 read(Reply),
 nl,
 ( (Reply==yes; Reply==y)
	->
	assert(yes(Question));
	assert(no(Question)), fail).
:- dynamic yes/1,no/1.
verify(S):-
(yes(S)
	->
	true;
	(no(S)
		->
		fail;
		askQuestion(S))).
undo :- retract(yes(_)),fail.
undo :- retract(no(_)),fail.
undo.