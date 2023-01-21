-- public.catentry definition

-- Drop table

-- DROP TABLE catentry;

CREATE TABLE catentry (
	catentry_id int4 NOT NULL,
	base_price numeric(19, 2) NULL,
	exclusive_price numeric(19, 2) NULL,
	extra_price numeric(19, 2) NULL,
	identifier varchar(255) NULL,
	images varchar(5000) NULL,
	long_desc varchar(255) NULL,
	markfordelete int4 NULL,
	offer_price numeric(19, 2) NULL,
	prod_qty int4 NOT NULL,
	product_name varchar(255) NULL,
	short_desc varchar(255) NULL,
	sort_order int4 NOT NULL,
	up_product_name varchar(255) NULL,
	CONSTRAINT catentry_pkey null,
	CONSTRAINT product_identifier null
);

-- public.category definition

-- Drop table

-- DROP TABLE public.category;

CREATE TABLE public.category (
	category_id int4 NOT NULL,
	identifier varchar(255) NULL,
	markfordelete int4 NULL,
	"name" varchar(255) NULL,
	CONSTRAINT category_pkey null
);

-- public.catgpenrel definition

-- Drop table

-- DROP TABLE public.catgpenrel;

CREATE TABLE public.catgpenrel (
	catentry_id int4 NOT NULL,
	category_id int4 NOT NULL,
	CONSTRAINT catgpenrel_pkey null,
	CONSTRAINT fkcr44816lv1q9wi6q6o98mswya FOREIGN KEY (catentry_id) REFERENCES public.catentry(catentry_id),
	CONSTRAINT fko4v4txq3fjjl1g8bjybg3fj8t FOREIGN KEY (category_id) REFERENCES public.category(category_id)
);
-- public.store definition

-- Drop table

-- DROP TABLE public.store;

CREATE TABLE public.store (
	store_id int4 NOT NULL,
	currency_code varchar(255) NULL,
	identifier varchar(255) NULL,
	markfordelete int4 NULL,
	store_name varchar(255) NULL,
	CONSTRAINT store_pkey null,
	CONSTRAINT uc_store_identifier null
);

-- public.storecatentry definition

-- Drop table

-- DROP TABLE public.storecatentry;

CREATE TABLE public.storecatentry (
	catentry_id int4 NOT NULL,
	store_id int4 NOT NULL,
	CONSTRAINT storecatentry_pkey null,
	CONSTRAINT fke4asxeetnxadqp2b95gc3yegg FOREIGN KEY (store_id) REFERENCES public.store(store_id),
	CONSTRAINT fknktfs6npqyg1wsh0f2tncki1s FOREIGN KEY (catentry_id) REFERENCES public.catentry(catentry_id)
);

insert into category values (1,'shirt_men',0,'shirts for him',true);
insert into category values (2,'shirt_women',0,'shirts for her',true);
insert into category values (3,'shorts_women',0,'shorts for her',true);
insert into category values (4,'shorts_men',0,'shorts for him',true);