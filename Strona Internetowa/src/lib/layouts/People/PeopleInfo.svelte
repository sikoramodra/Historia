<script>
	export let data;
	export let closePopup;
</script>

<!-- <div class="text-center h-[85%] w-[85%] bg-gray-800 bg rounded-xl overflow-auto p-1 shadow-lg relative m-4 cursor-default border border-white">
	<div class="bg-gray-900 bg-opacity-20 rounded-xl shadow-2xl shadow-gray-900 relative p-4">
		<button class="absolute top-4 right-4 text-white text-2xl focus:outline-none" on:click={closePopup}>
			<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-lg" viewBox="0 0 16 16">
				<path
					d="M2.146 2.854a.5.5 0 1 1 .708-.708L8 7.293l5.146-5.147a.5.5 0 0 1 .708.708L8.707 8l5.147 5.146a.5.5 0 0 1-.708.708L8 8.707l-5.146 5.147a.5.5 0 0 1-.708-.708L7.293 8z"
				/>
			</svg>
		</button>

		{#if data}
			<div class="rounded-lg max-w-min max-h-min p-4 px-8 m-auto mb-4">
				<h2 class="text-4xl font-bold text-white">{data.name}</h2>
			</div>
			<div class="grid grid-cols-1 md:grid-cols-2 gap-y-6 md:gap-x-8 divide-y text-xl capitalize">
				<div class="pb-4 pt-2 rounded-lg border-t border-white border-opacity-90">
					<p class="text-2xl font-semibold text-gray-300 mb-2">Epitafium:</p>
					<p class=" text-gray-400">{data.inscription || "Brak Danych..."}</p>
				</div>

				<div class="pb-4 pt-2 rounded-lg">
					<p class="text-2xl font-semibold text-gray-300 mb-2">Alternatywne Imiona i Nazwiska:</p>
					<p class=" text-gray-400">{data.other_names.join(", ") || "Brak Danych..."}</p>
				</div>

				<div class="pb-4 pt-2 rounded-lg">
					<p class="text-2xl font-semibold text-gray-300 mb-2">Pseudonimy:</p>
					<p class=" text-gray-400">{data.code_names.join(", ") || "Brak Danych..."}</p>
				</div>

				<div class="pb-4 pt-2 rounded-lg">
					<p class="text-2xl font-semibold text-gray-300 mb-2">Data Urodzenia:</p>
					<p class=" text-gray-400">{data.birth_date || "Brak Danych..."}</p>
				</div>

				<div class="pb-4 pt-2 rounded-lg">
					<p class="text-2xl font-semibold text-gray-300 mb-2">Miejsce Urodzenia:</p>
					<p class=" text-gray-400">{data.birth_place || "Brak Danych..."}</p>
				</div>

				<div class="pb-4 pt-2 rounded-lg">
					<p class="text-2xl font-semibold text-gray-300 mb-2">Data Śmierci:</p>
					<p class=" text-gray-400">{data.death_date || "Brak Danych..."}</p>
				</div>

				<div class="pb-4 pt-2 rounded-lg">
					<p class="text-2xl font-semibold text-gray-300 mb-2">Miejsce Śmierci:</p>
					<p class=" text-gray-400">{data.death_place || "Brak Danych..."}</p>
				</div>

				<div class="pb-4 pt-2 rounded-lg">
					<p class="text-2xl font-semibold text-gray-300 mb-2">Stopień Wojskowy:</p>
					{#if data.ranks}
						{#each data.ranks as rank}
							<p class="text-gray-400">{rank}</p>
						{/each}
					{:else}
						<p class="text-gray-400">Brak Danych...</p>
					{/if}
				</div>

				<div class="pb-4 pt-2 rounded-lg">
					<p class="text-2xl font-semibold text-gray-300 mb-2">Odznaczenia:</p>
					{#if data.badges}
						{#each data.badges as badge}
							<p class=" text-gray-400">{badge.badge || ""}</p>
							{#each badge.sub_badges as subBadge}
								<p class=" text-gray-400 ml-4">{subBadge || ""}</p>
							{/each}
						{/each}
					{:else}
						<p class="text-gray-400">Brak Danych...</p>
					{/if}
				</div>

				<div class="pb-4 pt-2 rounded-lg">
					<p class="text-2xl font-semibold text-gray-300 mb-2">Wydarzenia:</p>
					{#if data.activity}
						{#each data.activity as activity}
							<div class="ml-4 border-l-4 border-gray-300 pr-4 mb-8 divide-y my-4 border-double">
								<p class="text-xl font-semibold text-gray-400 mb-2">{activity.name}</p>
								{#each activity.sub_activity as subActivity}
									<div class="ml-4 border-l-4 border-gray-400 border-double pr-4 py-4">
										<p class="text-lg font-semibold text-gray-300 mb-2 mx-16 border-b">{subActivity.name}:</p>
										{#each subActivity.events as event}
											<p class="text-base text-gray-400 mr-4 underline-offset-4 underline">{event}</p>
										{/each}
									</div>
								{/each}
							</div>
						{/each}
					{:else}
						<p class="text-gray-400">Brak Danych...</p>
					{/if}
				</div>

				<div class="pb-4 pt-2 rounded-lg">
					<p class="text-2xl font-semibold text-gray-300 mb-2">Opis:</p>
					<p class=" text-gray-400">{data.description || "Brak Danych..."}</p>
				</div>

				<div class="pb-4 pt-2 rounded-lg">
					<p class="text-2xl font-semibold text-gray-300 mb-2">Źródła:</p>
					<p class=" text-gray-400">{data.sources || "Brak Danych..."}</p>
				</div>
			</div>
		{:else}
			<p class="text-xl font-semibold text-white">Nie wybrano osoby</p>
		{/if}
	</div>
</div> -->

<div
	class="text-center h-[85%] w-[85%] bg-gray-800 bg rounded-xl overflow-auto p-1 shadow-lg relative m-4 cursor-default border border-white text-gray-300"
>
	<div class="bg-gray-900 bg-opacity-20 rounded-xl shadow-2xl shadow-gray-900 relative p-4 w-full">
		<button class="absolute top-4 right-4 text-white text-2xl focus:outline-none"
			><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-lg" viewBox="0 0 16 16">
				<path
					d="M2.146 2.854a.5.5 0 1 1 .708-.708L8 7.293l5.146-5.147a.5.5 0 0 1 .708.708L8.707 8l5.147 5.146a.5.5 0 0 1-.708.708L8 8.707l-5.146 5.147a.5.5 0 0 1-.708-.708L7.293 8z"
					class="s-mWJ8Gt6s9mwW"
				>
				</path>
			</svg></button
		>
		<div class="rounded-lg max-h-min p-4 mb-4 w-full">
			<h2 class="text-4xl font-bold text-white w-full mb-2">{data.name}</h2>
			<div class="flex justify-center gap-x-2 flex-wrap mb-2">
				<p class="text-xl font-semibold text-gray-300">Alternatywne Imiona i Nazwiska:</p>
				<p class="text-xl font-semibold text-gray-400">{data.other_names.join(", ") || "Brak Danych..."}</p>
			</div>
			<div class="flex justify-center gap-x-2 flex-wrap mb-2">
				<p class="text-xl font-semibold text-gray-300">Pseudonimy:</p>
				<p class="text-xl font-semibold text-gray-400">{data.code_names.join(", ") || "Brak Danych..."}</p>
			</div>
		</div>
		<div class="flex flex-wrap flex-col justify-start xl:flex-nowrap xl:flex-row xl:justify-around gap-y-6 md:gap-x-8 text-xl capitalize">
			<div class="hidden md:flex min-w-[500px] flex flex-col justify-center">
				<div class="flex justify-around mb-2">
					<p>
						<svg
							height="40px"
							width="40px"
							version="1.1"
							id="_x32_"
							xmlns="http://www.w3.org/2000/svg"
							xmlns:xlink="http://www.w3.org/1999/xlink"
							viewBox="0 0 512 512"
							xml:space="preserve"
							fill="#b4b4b4"
						>
							<g id="SVGRepo_bgCarrier" stroke-width="0"></g>
							<g id="SVGRepo_tracerCarrier" stroke-linecap="round" stroke-linejoin="round"></g>
							<g id="SVGRepo_iconCarrier">
								<style type="text/css">
									.st0 {
										fill: #b4b4b4;
									}
								</style>
								<g>
									<circle class="st0" cx="219.869" cy="183.266" r="9.765"></circle>
									<path
										class="st0"
										d="M292.131,173.5c-5.398,0-9.772,4.375-9.772,9.766s4.374,9.765,9.772,9.765c5.391,0,9.766-4.374,9.766-9.765 S297.523,173.5,292.131,173.5z"
									></path>
									<path
										class="st0"
										d="M358.949,157.488c-4.882-22.935-17.149-43.134-34.205-57.969c-18.627-16.2-43.02-26.032-69.647-26.032 c-26.587,0-50.94,9.798-69.554,25.958c-17.156,14.882-29.49,35.182-34.339,58.237c-7.076,0.923-13.444,4.207-18.233,8.989 c-5.725,5.733-9.29,13.712-9.29,22.46c0,8.729,3.565,16.715,9.29,22.44c5.725,5.725,13.705,9.284,22.447,9.284 c0.602,0,1.19-0.014,1.779-0.04c4.508,10.715,10.742,20.54,18.327,29.135l-1.204,0.89l101.071,136.226l11.764-8.735l-19.805-26.688 l65.394-96.662l-1.678-1.137c9.277-9.504,16.781-20.735,21.998-33.188c1.137,0.127,2.32,0.201,3.512,0.201 c8.741,0,16.714-3.559,22.439-9.284c5.726-5.725,9.298-13.711,9.298-22.44c0-8.748-3.572-16.728-9.298-22.46 C373.812,161.474,366.755,158.063,358.949,157.488z M243.385,88.897c3.839-0.488,7.746-0.756,11.712-0.756 c5.384,0,10.641,0.475,15.778,1.364c0.521,0.609,1.07,1.318,1.618,2.14c2.314,3.512,4.648,9.023,4.668,17.745 c0,6.601-1.391,15.07-5.31,25.724c-12.36-9.939-19.397-19.096-23.383-26.64c-4.334-8.227-5.117-14.581-5.124-18.26 C243.345,89.72,243.359,89.285,243.385,88.897z M234.556,90.455c0.034,4.977,1.191,12.762,6.14,22.119 c2.214,4.194,5.177,8.695,9.11,13.404c-3.933-1.585-7.866-3.063-11.572-4.628c-6.367-2.682-11.958-5.685-15.752-9.685 c-1.906-2-3.397-4.247-4.461-6.956c-0.883-2.254-1.445-4.882-1.619-7.993C222.156,94.027,228.229,91.907,234.556,90.455z M368.661,201.198c-3.123,3.103-7.344,5.01-12.086,5.01c-1.96,0-3.84-0.355-5.652-0.977l-6.943-2.448l-2.421,6.943 c-6.207,17.885-17.818,33.275-32.881,44.171c-3.946,2.856-8.114,5.411-12.494,7.604c0.307,2.007,0.455,4.034,0.455,6.094 c0,3.558-0.455,7.043-1.338,10.401c2.034-0.836,4.04-1.733,6.006-2.696L258.1,339.175l-46.438-62.592 c1.725,0.776,3.464,1.519,5.237,2.201c-1.03-3.586-1.552-7.351-1.552-11.19c0-1.772,0.114-3.545,0.347-5.27 c-4.922-2.348-9.591-5.124-13.965-8.274c-15.036-10.815-26.667-26.092-32.948-43.857l-2.267-6.421l-6.562,1.806 c-1.512,0.408-3.003,0.629-4.535,0.629c-4.736,0-8.976-1.906-12.08-5.01c-3.103-3.104-5.01-7.337-5.01-12.066 c0-4.749,1.907-8.983,5.01-12.086c3.103-3.11,7.344-5.01,12.08-5.01c0.301,0,0.736,0.034,1.351,0.074l6.809,0.528l1.016-6.736 c3.311-22.005,14.474-41.441,30.54-55.387c4.013-3.478,8.334-6.622,12.908-9.37c0.402,2.482,1.01,4.809,1.86,6.949 c1.351,3.391,3.25,6.327,5.492,8.842c3.933,4.401,8.849,7.498,13.986,10.039c7.718,3.793,16.052,6.415,23.055,9.685 c3.498,1.626,6.648,3.391,9.237,5.432c2.582,2.04,4.602,4.307,6.046,7.07c0.776,1.492,2.328,2.401,4.006,2.368 c1.679-0.04,3.178-1.023,3.88-2.555c7.605-16.461,10.334-29.41,10.34-39.583c0.013-6.936-1.291-12.554-3.137-16.969 c12.039,3.819,23.002,10.046,32.332,18.153c16.079,13.993,27.208,33.469,30.493,55.528l1.084,7.264l7.27-1.11 c0.964-0.147,1.806-0.221,2.589-0.221c4.742,0,8.962,1.9,12.086,5.01c3.103,3.103,4.99,7.337,5.01,12.086 C373.651,193.86,371.765,198.094,368.661,201.198z"
									></path>
									<path
										class="st0"
										d="M256,235.744c-8.776,0-16.788,3.579-22.527,9.33c-5.752,5.739-9.337,13.758-9.33,22.527 c-0.006,8.768,3.578,16.782,9.33,22.526c5.739,5.753,13.751,9.331,22.527,9.324c8.769,0.006,16.782-3.572,22.527-9.324 c5.752-5.745,9.324-13.758,9.324-22.526c0-8.769-3.572-16.788-9.324-22.527C272.782,239.322,264.769,235.744,256,235.744z M270.822,273.855c-1.218,2.876-3.264,5.344-5.84,7.082c-2.575,1.733-5.625,2.736-8.982,2.736c-2.247,0-4.341-0.449-6.254-1.258 c-2.883-1.211-5.35-3.264-7.083-5.833c-1.739-2.575-2.742-5.625-2.742-8.982c0-2.248,0.455-4.341,1.258-6.261 c1.218-2.869,3.264-5.344,5.832-7.083c2.582-1.732,5.632-2.736,8.99-2.736c2.24,0,4.334,0.448,6.254,1.258 c2.876,1.217,5.344,3.27,7.084,5.839c1.739,2.568,2.735,5.625,2.742,8.983C272.079,269.842,271.624,271.935,270.822,273.855z"
									></path>
									<path
										class="st0"
										d="M256,216.641c-21.631,0-39.182,10.488-39.182,23.437c0,3.86,1.565,7.504,4.348,10.735 c1.686-2.789,3.739-5.391,6.093-7.752c7.659-7.678,17.865-11.906,28.727-11.906c10.896,0,21.089,4.227,28.761,11.918 c2.361,2.348,4.401,4.95,6.086,7.739c2.783-3.231,4.348-6.876,4.348-10.735C295.181,227.129,277.645,216.641,256,216.641z"
									></path>
									<path
										class="st0"
										d="M421.133,175.968l-8.776,0.448l8.776-0.455c-1.485-29.53-11.451-55.481-25.624-77.453 c-10.641-16.494-23.63-30.808-37.322-43.041C337.64,37.121,315.528,23.45,297.081,14.26c-9.23-4.595-17.537-8.066-24.386-10.434 c-3.424-1.191-6.474-2.107-9.19-2.756c-1.351-0.321-2.622-0.576-3.839-0.762C258.435,0.127,257.271,0,256,0 c-1.137,0-2.181,0.1-3.264,0.247c-2.08,0.294-4.307,0.796-6.828,1.499c-4.703,1.304-10.408,3.317-16.929,6.053 c-11.411,4.782-25.283,11.791-39.877,21.068c-21.871,13.926-45.348,32.948-64.009,57.401c-9.324,12.226-17.43,25.818-23.443,40.793 c-6.007,14.962-9.893,31.309-10.789,48.9c-0.422,8.388-0.656,17.604-0.656,27.476c0,27.556,1.832,60.25,6.622,93.92 c3.592,25.256,8.842,51.06,16.28,75.674c5.572,18.46,12.374,36.252,20.654,52.639c12.441,24.574,28.232,46.064,48.458,61.574 c10.106,7.746,21.316,13.966,33.637,18.213c12.313,4.261,25.724,6.548,40.144,6.542c17.089,0.006,32.76-3.211,46.873-9.103 c12.347-5.15,23.504-12.327,33.483-21.035c17.471-15.257,31.396-35.149,42.559-57.555c16.741-33.616,27.376-73.005,33.924-111.906 c6.535-38.9,8.956-77.313,8.956-108.956C421.795,193.566,421.555,184.349,421.133,175.968z M397.77,294.884 c-3.491,24.534-8.588,49.515-15.705,73.065c-5.33,17.664-11.798,34.527-19.517,49.79c-11.585,22.922-25.992,42.185-43.455,55.555 c-8.742,6.689-18.253,11.946-28.688,15.551c-10.44,3.605-21.831,5.578-34.405,5.578c-14.909-0.007-28.146-2.769-40.111-7.752 c-10.468-4.368-19.979-10.454-28.687-18.059c-15.236-13.277-27.972-31.235-38.392-52.144 c-15.638-31.356-25.985-69.252-32.319-106.983c-6.348-37.723-8.715-75.293-8.708-106.046c0-9.592,0.227-18.527,0.642-26.58 c1.325-26.098,10.026-48.933,22.835-68.825c9.605-14.902,21.531-28.091,34.259-39.462c19.089-17.056,39.997-29.998,57.234-38.58 c8.608-4.288,16.313-7.491,22.3-9.564c2.99-1.03,5.558-1.792,7.518-2.254c0.97-0.234,1.799-0.394,2.408-0.488 c0.602-0.094,1.009-0.114,1.023-0.107c0.014-0.007,0.334,0.013,0.829,0.08c0.963,0.134,2.568,0.468,4.562,1.023 c3.746,1.037,8.869,2.816,14.835,5.324c10.448,4.388,23.537,10.976,37.229,19.691c20.56,13.075,42.492,30.954,59.474,53.233 c8.494,11.137,15.764,23.37,21.102,36.674c5.338,13.31,8.755,27.684,9.552,43.254c0.401,8.053,0.635,16.989,0.635,26.587 C404.218,230.219,402.418,262.163,397.77,294.884z"
									></path>
								</g>
							</g>
						</svg>
					</p>

					<p>
						<svg
							height="40px"
							width="40px"
							version="1.1"
							id="_x32_"
							xmlns="http://www.w3.org/2000/svg"
							xmlns:xlink="http://www.w3.org/1999/xlink"
							viewBox="0 0 512 512"
							xml:space="preserve"
							fill="#b4b4b4"
							stroke="#b4b4b4"
						>
							<g id="SVGRepo_bgCarrier" stroke-width="0"></g>
							<g id="SVGRepo_tracerCarrier" stroke-linecap="round" stroke-linejoin="round"></g>
							<g id="SVGRepo_iconCarrier">
								<style type="text/css">
									.st0 {
										fill: #b4b4b4;
									}
								</style>
								<g>
									<path
										class="st0"
										d="M428.466,386.01V164.97C428.451,73.851,354.608,0.008,263.493,0H248.51 C157.392,0.008,83.548,73.851,83.541,164.97v221.04H44.166V512h423.668v-14.997V386.01H428.466z M113.535,164.97 c0.008-37.318,15.086-70.974,39.529-95.446c24.473-24.444,58.129-39.521,95.446-39.529h14.983 c37.32,0.008,70.962,15.085,95.435,39.529c24.459,24.473,39.529,58.129,39.544,95.446v221.04H113.535V164.97z M74.161,416.004 h363.679v66.001H74.161V416.004z"
									></path>
									<polygon
										class="st0"
										points="275.297,149.504 236.706,149.504 236.706,203.092 181.799,203.092 181.799,241.823 236.706,241.823 236.706,327.596 275.297,327.596 275.297,241.823 330.208,241.823 330.208,203.092 275.297,203.092 "
									></polygon>
								</g>
							</g>
						</svg>
					</p>
				</div>

				<div class="flex justify-around gap-4">
					<div class="flex flex-col justify-center">
						<div class="flex gap-x-2 flex-wrap mb-2">
							<p class="text-xl text-start font-semibold text-gray-300">Miejsce urodzenia:</p>
							<p class="font-semibold text-gray-400">{data.birth_place || "Brak Danych..."}</p>
						</div>
						<div class="flex gap-x-2 flex-wrap mb-2">
							<p class="text-xl text-start font-semibold text-gray-300">Data urodzenia:</p>
							<p class="font-semibold text-gray-400">{data.birth_date || "Brak Danych..."}</p>
						</div>
					</div>
					<div class="flex items-center">
						<div class="w-[50px] xl:w-[30px] h-[2px] bg-[rgb(209,213,219)] mx-[20px] xl:mx-[5px]"></div>
					</div>
					<div class="flex flex-col justify-center">
						<div class="flex justify-end gap-x-2 flex-wrap mb-2">
							<p class="text-xl text-end font-semibold text-gray-300">Miejsce śmierci:</p>
							<p class="font-semibold text-gray-400 text-end">{data.death_place || "Brak Danych..."}</p>
						</div>
						<div class="flex justify-end gap-x-2 flex-wrap mb-2">
							<p class="text-xl text-end font-semibold text-gray-300">Data śmierci:</p>
							<p class="font-semibold text-end text-gray-400">{data.death_date || "Brak Danych..."}</p>
						</div>
					</div>
				</div>
				<div class="mt-5">
					<p class="text-2xl font-semibold text-gray-300 mb-2">Epitafium:</p>
					<p class="text-gray-400">{data.inscription || "Brak Danych..."}</p>
				</div>
			</div>
			<div class="block md:hidden">
				<p class="flex justify-center">
					<svg
						height="40px"
						width="40px"
						version="1.1"
						id="_x32_"
						xmlns="http://www.w3.org/2000/svg"
						xmlns:xlink="http://www.w3.org/1999/xlink"
						viewBox="0 0 512 512"
						xml:space="preserve"
						fill="#b4b4b4"
					>
						<g id="SVGRepo_bgCarrier" stroke-width="0"></g>
						<g id="SVGRepo_tracerCarrier" stroke-linecap="round" stroke-linejoin="round"></g>
						<g id="SVGRepo_iconCarrier">
							<style type="text/css">
								.st0 {
									fill: #b4b4b4;
								}
							</style>
							<g>
								<circle class="st0" cx="219.869" cy="183.266" r="9.765"></circle>
								<path
									class="st0"
									d="M292.131,173.5c-5.398,0-9.772,4.375-9.772,9.766s4.374,9.765,9.772,9.765c5.391,0,9.766-4.374,9.766-9.765 S297.523,173.5,292.131,173.5z"
								></path>
								<path
									class="st0"
									d="M358.949,157.488c-4.882-22.935-17.149-43.134-34.205-57.969c-18.627-16.2-43.02-26.032-69.647-26.032 c-26.587,0-50.94,9.798-69.554,25.958c-17.156,14.882-29.49,35.182-34.339,58.237c-7.076,0.923-13.444,4.207-18.233,8.989 c-5.725,5.733-9.29,13.712-9.29,22.46c0,8.729,3.565,16.715,9.29,22.44c5.725,5.725,13.705,9.284,22.447,9.284 c0.602,0,1.19-0.014,1.779-0.04c4.508,10.715,10.742,20.54,18.327,29.135l-1.204,0.89l101.071,136.226l11.764-8.735l-19.805-26.688 l65.394-96.662l-1.678-1.137c9.277-9.504,16.781-20.735,21.998-33.188c1.137,0.127,2.32,0.201,3.512,0.201 c8.741,0,16.714-3.559,22.439-9.284c5.726-5.725,9.298-13.711,9.298-22.44c0-8.748-3.572-16.728-9.298-22.46 C373.812,161.474,366.755,158.063,358.949,157.488z M243.385,88.897c3.839-0.488,7.746-0.756,11.712-0.756 c5.384,0,10.641,0.475,15.778,1.364c0.521,0.609,1.07,1.318,1.618,2.14c2.314,3.512,4.648,9.023,4.668,17.745 c0,6.601-1.391,15.07-5.31,25.724c-12.36-9.939-19.397-19.096-23.383-26.64c-4.334-8.227-5.117-14.581-5.124-18.26 C243.345,89.72,243.359,89.285,243.385,88.897z M234.556,90.455c0.034,4.977,1.191,12.762,6.14,22.119 c2.214,4.194,5.177,8.695,9.11,13.404c-3.933-1.585-7.866-3.063-11.572-4.628c-6.367-2.682-11.958-5.685-15.752-9.685 c-1.906-2-3.397-4.247-4.461-6.956c-0.883-2.254-1.445-4.882-1.619-7.993C222.156,94.027,228.229,91.907,234.556,90.455z M368.661,201.198c-3.123,3.103-7.344,5.01-12.086,5.01c-1.96,0-3.84-0.355-5.652-0.977l-6.943-2.448l-2.421,6.943 c-6.207,17.885-17.818,33.275-32.881,44.171c-3.946,2.856-8.114,5.411-12.494,7.604c0.307,2.007,0.455,4.034,0.455,6.094 c0,3.558-0.455,7.043-1.338,10.401c2.034-0.836,4.04-1.733,6.006-2.696L258.1,339.175l-46.438-62.592 c1.725,0.776,3.464,1.519,5.237,2.201c-1.03-3.586-1.552-7.351-1.552-11.19c0-1.772,0.114-3.545,0.347-5.27 c-4.922-2.348-9.591-5.124-13.965-8.274c-15.036-10.815-26.667-26.092-32.948-43.857l-2.267-6.421l-6.562,1.806 c-1.512,0.408-3.003,0.629-4.535,0.629c-4.736,0-8.976-1.906-12.08-5.01c-3.103-3.104-5.01-7.337-5.01-12.066 c0-4.749,1.907-8.983,5.01-12.086c3.103-3.11,7.344-5.01,12.08-5.01c0.301,0,0.736,0.034,1.351,0.074l6.809,0.528l1.016-6.736 c3.311-22.005,14.474-41.441,30.54-55.387c4.013-3.478,8.334-6.622,12.908-9.37c0.402,2.482,1.01,4.809,1.86,6.949 c1.351,3.391,3.25,6.327,5.492,8.842c3.933,4.401,8.849,7.498,13.986,10.039c7.718,3.793,16.052,6.415,23.055,9.685 c3.498,1.626,6.648,3.391,9.237,5.432c2.582,2.04,4.602,4.307,6.046,7.07c0.776,1.492,2.328,2.401,4.006,2.368 c1.679-0.04,3.178-1.023,3.88-2.555c7.605-16.461,10.334-29.41,10.34-39.583c0.013-6.936-1.291-12.554-3.137-16.969 c12.039,3.819,23.002,10.046,32.332,18.153c16.079,13.993,27.208,33.469,30.493,55.528l1.084,7.264l7.27-1.11 c0.964-0.147,1.806-0.221,2.589-0.221c4.742,0,8.962,1.9,12.086,5.01c3.103,3.103,4.99,7.337,5.01,12.086 C373.651,193.86,371.765,198.094,368.661,201.198z"
								></path>
								<path
									class="st0"
									d="M256,235.744c-8.776,0-16.788,3.579-22.527,9.33c-5.752,5.739-9.337,13.758-9.33,22.527 c-0.006,8.768,3.578,16.782,9.33,22.526c5.739,5.753,13.751,9.331,22.527,9.324c8.769,0.006,16.782-3.572,22.527-9.324 c5.752-5.745,9.324-13.758,9.324-22.526c0-8.769-3.572-16.788-9.324-22.527C272.782,239.322,264.769,235.744,256,235.744z M270.822,273.855c-1.218,2.876-3.264,5.344-5.84,7.082c-2.575,1.733-5.625,2.736-8.982,2.736c-2.247,0-4.341-0.449-6.254-1.258 c-2.883-1.211-5.35-3.264-7.083-5.833c-1.739-2.575-2.742-5.625-2.742-8.982c0-2.248,0.455-4.341,1.258-6.261 c1.218-2.869,3.264-5.344,5.832-7.083c2.582-1.732,5.632-2.736,8.99-2.736c2.24,0,4.334,0.448,6.254,1.258 c2.876,1.217,5.344,3.27,7.084,5.839c1.739,2.568,2.735,5.625,2.742,8.983C272.079,269.842,271.624,271.935,270.822,273.855z"
								></path>
								<path
									class="st0"
									d="M256,216.641c-21.631,0-39.182,10.488-39.182,23.437c0,3.86,1.565,7.504,4.348,10.735 c1.686-2.789,3.739-5.391,6.093-7.752c7.659-7.678,17.865-11.906,28.727-11.906c10.896,0,21.089,4.227,28.761,11.918 c2.361,2.348,4.401,4.95,6.086,7.739c2.783-3.231,4.348-6.876,4.348-10.735C295.181,227.129,277.645,216.641,256,216.641z"
								></path>
								<path
									class="st0"
									d="M421.133,175.968l-8.776,0.448l8.776-0.455c-1.485-29.53-11.451-55.481-25.624-77.453 c-10.641-16.494-23.63-30.808-37.322-43.041C337.64,37.121,315.528,23.45,297.081,14.26c-9.23-4.595-17.537-8.066-24.386-10.434 c-3.424-1.191-6.474-2.107-9.19-2.756c-1.351-0.321-2.622-0.576-3.839-0.762C258.435,0.127,257.271,0,256,0 c-1.137,0-2.181,0.1-3.264,0.247c-2.08,0.294-4.307,0.796-6.828,1.499c-4.703,1.304-10.408,3.317-16.929,6.053 c-11.411,4.782-25.283,11.791-39.877,21.068c-21.871,13.926-45.348,32.948-64.009,57.401c-9.324,12.226-17.43,25.818-23.443,40.793 c-6.007,14.962-9.893,31.309-10.789,48.9c-0.422,8.388-0.656,17.604-0.656,27.476c0,27.556,1.832,60.25,6.622,93.92 c3.592,25.256,8.842,51.06,16.28,75.674c5.572,18.46,12.374,36.252,20.654,52.639c12.441,24.574,28.232,46.064,48.458,61.574 c10.106,7.746,21.316,13.966,33.637,18.213c12.313,4.261,25.724,6.548,40.144,6.542c17.089,0.006,32.76-3.211,46.873-9.103 c12.347-5.15,23.504-12.327,33.483-21.035c17.471-15.257,31.396-35.149,42.559-57.555c16.741-33.616,27.376-73.005,33.924-111.906 c6.535-38.9,8.956-77.313,8.956-108.956C421.795,193.566,421.555,184.349,421.133,175.968z M397.77,294.884 c-3.491,24.534-8.588,49.515-15.705,73.065c-5.33,17.664-11.798,34.527-19.517,49.79c-11.585,22.922-25.992,42.185-43.455,55.555 c-8.742,6.689-18.253,11.946-28.688,15.551c-10.44,3.605-21.831,5.578-34.405,5.578c-14.909-0.007-28.146-2.769-40.111-7.752 c-10.468-4.368-19.979-10.454-28.687-18.059c-15.236-13.277-27.972-31.235-38.392-52.144 c-15.638-31.356-25.985-69.252-32.319-106.983c-6.348-37.723-8.715-75.293-8.708-106.046c0-9.592,0.227-18.527,0.642-26.58 c1.325-26.098,10.026-48.933,22.835-68.825c9.605-14.902,21.531-28.091,34.259-39.462c19.089-17.056,39.997-29.998,57.234-38.58 c8.608-4.288,16.313-7.491,22.3-9.564c2.99-1.03,5.558-1.792,7.518-2.254c0.97-0.234,1.799-0.394,2.408-0.488 c0.602-0.094,1.009-0.114,1.023-0.107c0.014-0.007,0.334,0.013,0.829,0.08c0.963,0.134,2.568,0.468,4.562,1.023 c3.746,1.037,8.869,2.816,14.835,5.324c10.448,4.388,23.537,10.976,37.229,19.691c20.56,13.075,42.492,30.954,59.474,53.233 c8.494,11.137,15.764,23.37,21.102,36.674c5.338,13.31,8.755,27.684,9.552,43.254c0.401,8.053,0.635,16.989,0.635,26.587 C404.218,230.219,402.418,262.163,397.77,294.884z"
								></path>
							</g>
						</g>
					</svg>
				</p>
				<div class="flex justify-center gap-x-2 flex-wrap mb-2">
					<p class="text-xl text-start font-semibold text-gray-300">Miejsce urodzenia:</p>
					<p class="font-semibold text-gray-400">{data.birth_place || "Brak Danych..."}</p>
				</div>
				<div class="flex justify-center gap-x-2 flex-wrap mb-2">
					<p class="text-xl text-start font-semibold text-gray-300">Data urodzenia:</p>
					<p class="font-semibold text-gray-400">{data.birth_date || "Brak Danych..."}</p>
				</div>

				<p class="flex justify-center mt-10">
					<svg
						height="40px"
						width="40px"
						version="1.1"
						id="_x32_"
						xmlns="http://www.w3.org/2000/svg"
						xmlns:xlink="http://www.w3.org/1999/xlink"
						viewBox="0 0 512 512"
						xml:space="preserve"
						fill="#b4b4b4"
						stroke="#b4b4b4"
					>
						<g id="SVGRepo_bgCarrier" stroke-width="0"></g>
						<g id="SVGRepo_tracerCarrier" stroke-linecap="round" stroke-linejoin="round"></g>
						<g id="SVGRepo_iconCarrier">
							<style type="text/css">
								.st0 {
									fill: #b4b4b4;
								}
							</style>
							<g>
								<path
									class="st0"
									d="M428.466,386.01V164.97C428.451,73.851,354.608,0.008,263.493,0H248.51 C157.392,0.008,83.548,73.851,83.541,164.97v221.04H44.166V512h423.668v-14.997V386.01H428.466z M113.535,164.97 c0.008-37.318,15.086-70.974,39.529-95.446c24.473-24.444,58.129-39.521,95.446-39.529h14.983 c37.32,0.008,70.962,15.085,95.435,39.529c24.459,24.473,39.529,58.129,39.544,95.446v221.04H113.535V164.97z M74.161,416.004 h363.679v66.001H74.161V416.004z"
								></path>
								<polygon
									class="st0"
									points="275.297,149.504 236.706,149.504 236.706,203.092 181.799,203.092 181.799,241.823 236.706,241.823 236.706,327.596 275.297,327.596 275.297,241.823 330.208,241.823 330.208,203.092 275.297,203.092 "
								></polygon>
							</g>
						</g>
					</svg>
				</p>
				<div class="flex justify-center gap-x-2 flex-wrap mb-2">
					<p class="text-xl text-start font-semibold text-gray-300">Miejsce śmierci:</p>
					<p class="font-semibold text-gray-400">{data.death_place || "Brak Danych..."}</p>
				</div>
				<div class="flex justify-center gap-x-2 flex-wrap mb-2">
					<p class="text-xl text-start font-semibold text-gray-300">Data śmierci:</p>
					<p class="font-semibold text-gray-400">{data.death_date || "Brak Danych..."}</p>
				</div>
			</div>

			<div class="block xl:hidden w-full flex justify-center">
				<div class="gradientWhiteHorizontal w-[200px] h-[2px]"></div>
			</div>

			<div class="gradientWhiteVertical w-[2px] hidden xl:block"></div>

			<div class="flex flex-col justify-center">
				<div>
					<p class="text-2xl font-semibold text-gray-300 mb-2">Odznaczenia:</p>
					{#if data.badges}
						{#each data.badges as badge}
							<p class=" text-gray-400">{badge.badge || ""}</p>
							{#each badge.sub_badges as subBadge}
								<p class=" text-gray-400">{subBadge || ""}</p>
							{/each}
						{/each}
					{:else}
						<p class="text-gray-400">Brak Danych...</p>
					{/if}
				</div>
				<div class="mt-8">
					<p class="text-2xl font-semibold text-gray-300 mb-2">Stopnie wojskowe:</p>
					{#if data.ranks}
						{#each data.ranks as rank}
							<p class="text-gray-400">{rank}</p>
						{/each}
					{:else}
						<p class="text-gray-400">Brak Danych...</p>
					{/if}
				</div>
			</div>
		</div>

		<div class="mt-16">
			<p class="text-3xl font-semibold text-gray-300 mb-2">Wydarzenia:</p>
			<div class="w-full flex justify-center mb-4">
				<div class="w-[75px] h-[2px] bg-gray-300"></div>
			</div>

			<div class="w-full flex gap-x-14 gap-y-8 flex-wrap justify-center">
				{#if data.activity.length === 0}
					<p class="text-gray-400">Brak Danych...</p>
				{:else}
					{#each data.activity as event}
						<div class="eventsShadow w-[400px] rounded-xl p-2">
							<p class="text-2xl font-semibold text-gray-300 mb-2">{event.name}</p>
							<div class="py-4">
								{#each event.sub_activity as sub_activity}
									<div class="w-full">
										<p class="text-lg font-semibold text-gray-300 mb-2 w-fit m-auto px-5 border-b">{sub_activity.name}:</p>
									</div>
									{#each sub_activity.events as battle}
										<p class="text-base text-gray-400">{battle || ""}</p>
									{/each}
								{/each}
							</div>
						</div>
					{/each}
				{/if}
			</div>
		</div>

		<div class="mt-16 mb-20">
			<p class="text-3xl font-semibold text-gray-300 mb-2">Cmentarz:</p>
			<div class="w-full flex justify-center mb-4">
				<div class="w-[75px] h-[2px] bg-gray-300"></div>
			</div>
			<p class="text-xl text-center text-gray-400 mx-1 sm:mx-4 md:mx-20 xl:mx-40">
				{#if data.cemetery}
					{data.cemetery}, kw. {data.quarter}, rz. {data.row}, gr. {data.grave}
				{:else}
					Brak Danych...
				{/if}
			</p>
		</div>

		<div class="mt-16 mb-20">
			<p class="text-3xl font-semibold text-gray-300 mb-2">Opis:</p>
			<div class="w-full flex justify-center mb-4">
				<div class="w-[75px] h-[2px] bg-gray-300"></div>
			</div>
			<p class="[text-indent:50px] text-justify mx-1 sm:mx-4 md:mx-20 xl:mx-40">
				{data.description || "Brak Danych..."}
			</p>
		</div>
	</div>
</div>

<style>
	::-webkit-scrollbar {
		width: 12px;
	}

	::-webkit-scrollbar-track {
		background-color: transparent;
		border-radius: 32px;
	}

	::-webkit-scrollbar-thumb {
		box-shadow: inset 0 0 6px rgb(15, 23, 42);
		background-color: rgba(31, 41, 55, 0.55);
		border-radius: 0.7rem;
	}

	body {
		display: flex;
		justify-content: center;
		align-items: center;
		background-color: rgb(30, 30, 0);
		height: 100vh;
		width: 100vw;
	}

	::-webkit-scrollbar {
		width: 12px;
	}

	::-webkit-scrollbar-track {
		background-color: transparent;
		border-radius: 32px;
	}

	::-webkit-scrollbar-thumb {
		box-shadow: inset 0 0 6px rgb(15, 23, 42);
		background-color: rgba(15, 23, 42, 0.55);
		border-radius: 0.7rem;
	}

	.eventsShadow {
		-webkit-box-shadow: 0px 5px 24px -10px rgba(0, 0, 0, 1);
		-moz-box-shadow: 0px 5px 24px -10px rgba(0, 0, 0, 1);
		box-shadow: 0px 5px 24px -10px rgba(0, 0, 0, 1);
	}

	.gradientWhiteVertical {
		background: rgb(255, 255, 255);
		background: linear-gradient(0deg, rgba(255, 255, 255, 0) 0%, rgb(175, 175, 175) 50%, rgba(255, 255, 255, 0) 100%);
	}

	.gradientWhiteHorizontal {
		background: rgb(255, 255, 255);
		background: linear-gradient(90deg, rgba(255, 255, 255, 0) 0%, rgb(175, 175, 175) 50%, rgba(255, 255, 255, 0) 100%);
	}
</style>
