#!/bin/bash

APIKEY="$1"
cpf="$2"
dataNascimento="$3"
nome="$4"


function prefixed(){
	local key="$1"
	local value="$2"

	local cmd =  "export IDWALL_TEST_$key=\"$value\""

	$cmd

}


export IDWALL_TEST_NOME="$nome"
export IDWALL_TEST_DATA_NASCIMENTO="$dataNascimento"
export IDWALL_TEST_NUMERO="$cpf"


export IDWALL_TEST_KEY="$APIKEY"

mvn test
