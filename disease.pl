go:-
write('Finish answer with (.)\n'),
write('Answer y==yes and n==no.\n'),
hypothesis(Disease),
write('I believe you have:'),
write(Disease),
nl,
undo.

/*Hypothesis that should be tested*/
hypothesis(cold):-cold,!.
hypothesis(malaria):-malaria,!.
hypothesis(tb):-tb,!.
hypothesis(hiv):-hiv,!.
hypothesis(arthritis):-arthritis,!.
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