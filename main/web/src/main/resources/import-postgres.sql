
INSERT INTO USERS(username,name,sir,email,pass,enabled) VALUES
  ('DDN','Oliver','OBrien','oliver.obrien@ucll.be','$2a$04$rUlX/CAImg8rZlr1mO5CCOMhQr3JTjOgpZhPDNuzanIElz0pL4HBO',1),
  ('Legend101','Sebastian','OBrien','seb.obrien@ucll.be','$2a$04$a34CAkmrAPX1md6lai09QOftVD91tdm1yId6KOLLznwPS10z.BE.O',1);

INSERT INTO USER_ROLES(userid,role) VALUES
  (1,'ROLE_ADMIN');
INSERT INTO USER_ROLES(userid,role) VALUES
  (1,'ROLE_USER');
INSERT INTO USER_ROLES(userid,role) VALUES
  (2,'ROLE_USER');

INSERT INTO recipe(description, directions, name,vegetarian,vegan,gluten,lactose,nuts) VALUES
  ('A simple breakfast that any aspiring novice chef can cook with a cheesy twist',
   'Break open the eggs in a large bowl. Thoroughly beat the eggs with a fork (whisks foams up the eggs and produces a mushy omelet)' ||
   'Heat up a pan on a medium fire and add a little butter. ' ||
   'Now add the egg mixture to the heated pan. ' ||
   'salt and pepper the top and grate the cheddar (or your choice of cheese) on the omelet.' ||
   'Once the bottom solidifies, fold one half of the omelet over the other. ' ||
   'Frequently flip the omelet to prevent burning (browning of the outside). ' ||
   'After a few minutes the omelet is complete. ',
   'Cheese omelet',
   TRUE,FALSE,FALSE,TRUE,FALSE );

INSERT INTO recipe(description, directions, name,vegetarian,vegan,gluten,lactose,nuts) VALUES
  ('A simple but tasty thai curry',
   'Dice the onion, quarter the mushrooms, and cut the paprika in circles. ' ||
   'Warm up some a tablespoon of oil in a wok pan on a high fire. ' ||
   'Once the oil is hot add the mushrooms. KEEP ON STIRRING AND FLIPPING THE MUSHROOMS!!! ' ||
   'The point is to only allow the vegetables to touch the wok for a few seconds to cook it without burning it. ' ||
   'after a minute add the paprika.' ||
   'Continue to wok. ' ||
   'after a few minutes take the vegies off and reduce the fire to a medium heat. ' ||
   'add some coconut oil. ' ||
   'fry up the onions. ' ||
   'add the coconut milk. ' ||
   'throw in the vegies. ' ||
   'add a tablespoon of curry paste. ' ||
   'add a tablespoon of brown sugar. ' ||
   'cook rice. ' ||
   'eat',
   'curry',
   FALSE,FALSE,FALSE,FALSE,FALSE );

INSERT INTO ingredient (amount, name, unit) VALUES
  (2,'Eggs','piece'),
  (50,'Cheese (I used cheddar)','gram'),
  (1,'Onion','piece'),
  (200,'Mushrooms','gram'),
  (250,'Paprika','gram'),
  (1,'Sharwoods Tandoori paste','tablespoon'),
  (1,'Brown sugar','tablespoon'),
  (0.5,'Basmati rice','cup');

INSERT INTO recipe_ingredients (recipe_id, ingredients_id) VALUES
  (1,1),
  (1,2),
  (2,3),
  (2,4),
  (2,5),
  (2,6),
  (2,7),
  (2,8);