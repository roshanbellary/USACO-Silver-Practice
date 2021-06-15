for dir in */; do
	if [[ -d $dir ]]; then
		cd "./$dir"
		if [[ ! -f ".keep" ]]; then
			touch .keep
		fi
		cd ..
	fi
done
