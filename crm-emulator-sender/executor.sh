#!/bin/bash

set -o errexit

if [[ -z "$CRM_SERVICE_URL" ]]; then
  echo '$CRM_SERVICE_URL is missing'
  exit 1
fi

jq -c '.[]' < "./MOCK_DATA.json" |
while read -r row; do
  curl -s -X POST -H 'Content-Type:application/json' -d "$row" $CRM_SERVICE_URL
  sleep .5
done