toc.dat                                                                                             0000600 0004000 0002000 00000020166 14605760312 0014450 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        PGDMP                       |         	   healthhub    16.0    16.0                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                    0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                    0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                    1262    54804 	   healthhub    DATABASE     �   CREATE DATABASE healthhub WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_United States.1252';
    DROP DATABASE healthhub;
                postgres    false         �            1259    54850    accounts-payable    TABLE     �   CREATE TABLE public."accounts-payable" (
    "payableId" bigint NOT NULL,
    amount double precision,
    "payableDate" date,
    status text
);
 &   DROP TABLE public."accounts-payable";
       public         heap    postgres    false         �            1259    54843    accounts-receivable    TABLE     �   CREATE TABLE public."accounts-receivable" (
    "receivableId" bigint NOT NULL,
    amount double precision,
    "receivableDate" date,
    status text
);
 )   DROP TABLE public."accounts-receivable";
       public         heap    postgres    false         �            1259    54838    general-ledger    TABLE     }   CREATE TABLE public."general-ledger" (
    "entryId" bigint NOT NULL,
    amount double precision,
    "accountDate" date
);
 $   DROP TABLE public."general-ledger";
       public         heap    postgres    false         �            1259    54812    invoice    TABLE     �   CREATE TABLE public.invoice (
    "invoiceId" bigint NOT NULL,
    amount double precision,
    "issueDate" date,
    "dueDate" date,
    "patientId" bigint
);
    DROP TABLE public.invoice;
       public         heap    postgres    false         �            1259    54857    medical_record    TABLE     �   CREATE TABLE public.medical_record (
    record_id bigint NOT NULL,
    diagnosis character varying,
    prescriptions character varying,
    patient_id_fk bigint
);
 "   DROP TABLE public.medical_record;
       public         heap    postgres    false         �            1259    54817    patient    TABLE     �   CREATE TABLE public.patient (
    patient_id bigint NOT NULL,
    patient_name text,
    date_of_birth date,
    contact character varying
);
    DROP TABLE public.patient;
       public         heap    postgres    false         �            1259    54824    payment    TABLE     �   CREATE TABLE public.payment (
    "transactionId" bigint NOT NULL,
    "paymentDate" date,
    amount double precision,
    type text,
    "invoiceId" bigint
);
    DROP TABLE public.payment;
       public         heap    postgres    false         �            1259    54805    users    TABLE     �   CREATE TABLE public.users (
    userid bigint NOT NULL,
    username character varying(100),
    email character varying(200),
    password character varying(200),
    role character(20)
);
    DROP TABLE public.users;
       public         heap    postgres    false                   0    54850    accounts-payable 
   TABLE DATA           X   COPY public."accounts-payable" ("payableId", amount, "payableDate", status) FROM stdin;
    public          postgres    false    221       4881.dat           0    54843    accounts-receivable 
   TABLE DATA           a   COPY public."accounts-receivable" ("receivableId", amount, "receivableDate", status) FROM stdin;
    public          postgres    false    220       4880.dat           0    54838    general-ledger 
   TABLE DATA           L   COPY public."general-ledger" ("entryId", amount, "accountDate") FROM stdin;
    public          postgres    false    219       4879.dat           0    54812    invoice 
   TABLE DATA           [   COPY public.invoice ("invoiceId", amount, "issueDate", "dueDate", "patientId") FROM stdin;
    public          postgres    false    216       4876.dat           0    54857    medical_record 
   TABLE DATA           \   COPY public.medical_record (record_id, diagnosis, prescriptions, patient_id_fk) FROM stdin;
    public          postgres    false    222       4882.dat           0    54817    patient 
   TABLE DATA           S   COPY public.patient (patient_id, patient_name, date_of_birth, contact) FROM stdin;
    public          postgres    false    217       4877.dat           0    54824    payment 
   TABLE DATA           \   COPY public.payment ("transactionId", "paymentDate", amount, type, "invoiceId") FROM stdin;
    public          postgres    false    218       4878.dat           0    54805    users 
   TABLE DATA           H   COPY public.users (userid, username, email, password, role) FROM stdin;
    public          postgres    false    215       4875.dat n           2606    54816    invoice Invoice_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.invoice
    ADD CONSTRAINT "Invoice_pkey" PRIMARY KEY ("invoiceId");
 @   ALTER TABLE ONLY public.invoice DROP CONSTRAINT "Invoice_pkey";
       public            postgres    false    216         l           2606    54811    users User_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY public.users
    ADD CONSTRAINT "User_pkey" PRIMARY KEY (userid);
 ;   ALTER TABLE ONLY public.users DROP CONSTRAINT "User_pkey";
       public            postgres    false    215         x           2606    54856 &   accounts-payable accounts-payable_pkey 
   CONSTRAINT     q   ALTER TABLE ONLY public."accounts-payable"
    ADD CONSTRAINT "accounts-payable_pkey" PRIMARY KEY ("payableId");
 T   ALTER TABLE ONLY public."accounts-payable" DROP CONSTRAINT "accounts-payable_pkey";
       public            postgres    false    221         v           2606    54849 ,   accounts-receivable accounts-receivable_pkey 
   CONSTRAINT     z   ALTER TABLE ONLY public."accounts-receivable"
    ADD CONSTRAINT "accounts-receivable_pkey" PRIMARY KEY ("receivableId");
 Z   ALTER TABLE ONLY public."accounts-receivable" DROP CONSTRAINT "accounts-receivable_pkey";
       public            postgres    false    220         t           2606    54842 "   general-ledger general-ledger_pkey 
   CONSTRAINT     k   ALTER TABLE ONLY public."general-ledger"
    ADD CONSTRAINT "general-ledger_pkey" PRIMARY KEY ("entryId");
 P   ALTER TABLE ONLY public."general-ledger" DROP CONSTRAINT "general-ledger_pkey";
       public            postgres    false    219         z           2606    54863 "   medical_record medical_record_pkey 
   CONSTRAINT     g   ALTER TABLE ONLY public.medical_record
    ADD CONSTRAINT medical_record_pkey PRIMARY KEY (record_id);
 L   ALTER TABLE ONLY public.medical_record DROP CONSTRAINT medical_record_pkey;
       public            postgres    false    222         p           2606    54823    patient patient_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.patient
    ADD CONSTRAINT patient_pkey PRIMARY KEY (patient_id);
 >   ALTER TABLE ONLY public.patient DROP CONSTRAINT patient_pkey;
       public            postgres    false    217         r           2606    54830    payment payment_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public.payment
    ADD CONSTRAINT payment_pkey PRIMARY KEY ("transactionId");
 >   ALTER TABLE ONLY public.payment DROP CONSTRAINT payment_pkey;
       public            postgres    false    218         {           2606    54864    medical_record patient_id_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.medical_record
    ADD CONSTRAINT patient_id_fk FOREIGN KEY (patient_id_fk) REFERENCES public.patient(patient_id) NOT VALID;
 F   ALTER TABLE ONLY public.medical_record DROP CONSTRAINT patient_id_fk;
       public          postgres    false    4720    222    217                                                                                                                                                                                                                                                                                                                                                                                                                  4881.dat                                                                                            0000600 0004000 0002000 00000000005 14605760312 0014255 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        \.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           4880.dat                                                                                            0000600 0004000 0002000 00000000005 14605760312 0014254 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        \.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           4879.dat                                                                                            0000600 0004000 0002000 00000000005 14605760312 0014264 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        \.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           4876.dat                                                                                            0000600 0004000 0002000 00000000005 14605760312 0014261 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        \.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           4882.dat                                                                                            0000600 0004000 0002000 00000000135 14605760312 0014262 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	He is not doing well	Meds	\N
2	Has a simple headache	Paracetemol	\N
66	Malaria	Tabs	2
\.


                                                                                                                                                                                                                                                                                                                                                                                                                                   4877.dat                                                                                            0000600 0004000 0002000 00000000207 14605760312 0014266 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	Marvin Nugmo	1989-05-05	0709234566
2	Karen Lime	1899-04-01	0702345986
4	Hero	1845-04-01	0702355986
5	Luke	2001-04-01	0702353986
\.


                                                                                                                                                                                                                                                                                                                                                                                         4878.dat                                                                                            0000600 0004000 0002000 00000000005 14605760312 0014263 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        \.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           4875.dat                                                                                            0000600 0004000 0002000 00000000507 14605760312 0014267 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        942	Henry	henry@gmail.com	henry1234	ADMIN               
529	Kels	kels@gmail.com	kels1234	FINANCE             
29	Gaby	gaby@gmail.com	gaby1234	HEALTH              
309	Jill	jill@gmail.com	jill1234	ADMIN               
273	Sam	sam@gmail.com	sam1234	ADMIN               
728	kenny	ken@gmail.com	ken1234	HEALTH              
\.


                                                                                                                                                                                         restore.sql                                                                                         0000600 0004000 0002000 00000017015 14605760312 0015374 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        --
-- NOTE:
--
-- File paths need to be edited. Search for $$PATH$$ and
-- replace it with the path to the directory containing
-- the extracted data files.
--
--
-- PostgreSQL database dump
--

-- Dumped from database version 16.0
-- Dumped by pg_dump version 16.0

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE healthhub;
--
-- Name: healthhub; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE healthhub WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_United States.1252';


ALTER DATABASE healthhub OWNER TO postgres;

\connect healthhub

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: accounts-payable; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."accounts-payable" (
    "payableId" bigint NOT NULL,
    amount double precision,
    "payableDate" date,
    status text
);


ALTER TABLE public."accounts-payable" OWNER TO postgres;

--
-- Name: accounts-receivable; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."accounts-receivable" (
    "receivableId" bigint NOT NULL,
    amount double precision,
    "receivableDate" date,
    status text
);


ALTER TABLE public."accounts-receivable" OWNER TO postgres;

--
-- Name: general-ledger; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."general-ledger" (
    "entryId" bigint NOT NULL,
    amount double precision,
    "accountDate" date
);


ALTER TABLE public."general-ledger" OWNER TO postgres;

--
-- Name: invoice; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.invoice (
    "invoiceId" bigint NOT NULL,
    amount double precision,
    "issueDate" date,
    "dueDate" date,
    "patientId" bigint
);


ALTER TABLE public.invoice OWNER TO postgres;

--
-- Name: medical_record; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.medical_record (
    record_id bigint NOT NULL,
    diagnosis character varying,
    prescriptions character varying,
    patient_id_fk bigint
);


ALTER TABLE public.medical_record OWNER TO postgres;

--
-- Name: patient; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.patient (
    patient_id bigint NOT NULL,
    patient_name text,
    date_of_birth date,
    contact character varying
);


ALTER TABLE public.patient OWNER TO postgres;

--
-- Name: payment; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.payment (
    "transactionId" bigint NOT NULL,
    "paymentDate" date,
    amount double precision,
    type text,
    "invoiceId" bigint
);


ALTER TABLE public.payment OWNER TO postgres;

--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    userid bigint NOT NULL,
    username character varying(100),
    email character varying(200),
    password character varying(200),
    role character(20)
);


ALTER TABLE public.users OWNER TO postgres;

--
-- Data for Name: accounts-payable; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."accounts-payable" ("payableId", amount, "payableDate", status) FROM stdin;
\.
COPY public."accounts-payable" ("payableId", amount, "payableDate", status) FROM '$$PATH$$/4881.dat';

--
-- Data for Name: accounts-receivable; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."accounts-receivable" ("receivableId", amount, "receivableDate", status) FROM stdin;
\.
COPY public."accounts-receivable" ("receivableId", amount, "receivableDate", status) FROM '$$PATH$$/4880.dat';

--
-- Data for Name: general-ledger; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."general-ledger" ("entryId", amount, "accountDate") FROM stdin;
\.
COPY public."general-ledger" ("entryId", amount, "accountDate") FROM '$$PATH$$/4879.dat';

--
-- Data for Name: invoice; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.invoice ("invoiceId", amount, "issueDate", "dueDate", "patientId") FROM stdin;
\.
COPY public.invoice ("invoiceId", amount, "issueDate", "dueDate", "patientId") FROM '$$PATH$$/4876.dat';

--
-- Data for Name: medical_record; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.medical_record (record_id, diagnosis, prescriptions, patient_id_fk) FROM stdin;
\.
COPY public.medical_record (record_id, diagnosis, prescriptions, patient_id_fk) FROM '$$PATH$$/4882.dat';

--
-- Data for Name: patient; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.patient (patient_id, patient_name, date_of_birth, contact) FROM stdin;
\.
COPY public.patient (patient_id, patient_name, date_of_birth, contact) FROM '$$PATH$$/4877.dat';

--
-- Data for Name: payment; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.payment ("transactionId", "paymentDate", amount, type, "invoiceId") FROM stdin;
\.
COPY public.payment ("transactionId", "paymentDate", amount, type, "invoiceId") FROM '$$PATH$$/4878.dat';

--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (userid, username, email, password, role) FROM stdin;
\.
COPY public.users (userid, username, email, password, role) FROM '$$PATH$$/4875.dat';

--
-- Name: invoice Invoice_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.invoice
    ADD CONSTRAINT "Invoice_pkey" PRIMARY KEY ("invoiceId");


--
-- Name: users User_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT "User_pkey" PRIMARY KEY (userid);


--
-- Name: accounts-payable accounts-payable_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."accounts-payable"
    ADD CONSTRAINT "accounts-payable_pkey" PRIMARY KEY ("payableId");


--
-- Name: accounts-receivable accounts-receivable_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."accounts-receivable"
    ADD CONSTRAINT "accounts-receivable_pkey" PRIMARY KEY ("receivableId");


--
-- Name: general-ledger general-ledger_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."general-ledger"
    ADD CONSTRAINT "general-ledger_pkey" PRIMARY KEY ("entryId");


--
-- Name: medical_record medical_record_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.medical_record
    ADD CONSTRAINT medical_record_pkey PRIMARY KEY (record_id);


--
-- Name: patient patient_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.patient
    ADD CONSTRAINT patient_pkey PRIMARY KEY (patient_id);


--
-- Name: payment payment_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.payment
    ADD CONSTRAINT payment_pkey PRIMARY KEY ("transactionId");


--
-- Name: medical_record patient_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.medical_record
    ADD CONSTRAINT patient_id_fk FOREIGN KEY (patient_id_fk) REFERENCES public.patient(patient_id) NOT VALID;


--
-- PostgreSQL database dump complete
--

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   