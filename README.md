# lein-marathon

`lein-marathon` enables it to convert the config file(config.edn) of Luminus-framework to Marathon-framework style one (JSON mode).

## Usage

Add lein-marathon to your plugin list in your project.clj:

```clojure
:plugins [[lein-marathon "0.1.0"]
```

Available commands:

```sh
$ lein marathon # default dev
$ lein marathon dev
$ lein marathon prod
```

If you make an app with Luminus web framework, a config file is generated at a specific directory.    
For example, in you project.clj, you may find a profile information added as below:

```clojure
:profiles
  {:uberjar {:omit-source true
             :aot :all
             :uberjar-name "testminsun.jar"
             :source-paths ["env/prod/clj"]
             :resource-paths ["env/prod/resources"]}

   :project/dev  {...
                  :source-paths ["env/dev/clj"]
                  :resource-paths ["env/dev/resources"]
                ...}

```

- `dev` is from `resource-paths` of `:project/dev`.
- `prod` is from `resource-paths` of `:uberjar`.

You just may change your config path in the project.clj.

### Result

It generated to `.marathon_config_dev` or `.marathon_config_prod`.

from `env/prod/resources/config.edn`

```clojure
{:production true
 :port 3000}
```

to `.marathon_config_prod`

```json
{"PRODUCTION":true,"PORT":3000}
```

You can just copy & paste to your marathon framework configuration on JSON mode.

![marathon-sample](https://cloud.githubusercontent.com/assets/562341/24897745/0d71c0e8-1ed5-11e7-94a9-131832e8db2b.png "marathon sample")


## *Note

- This version only works on Luminus framework. So your project must be written in  Luminus style. A framework-independent version would be updated soon.

- Any feature you want is welcome!
  - Plz Report on issue
- PR is also welcome 🤗

## Reference

If you want to create environment variables file(eg. ENV_VAR1=1 ...) for Docker containers. Recommend orend's [lein-var-file].

## License

Copyright © 2017 Minsun Lee

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.

[lein-var-file]: https://github.com/orend/lein-var-file
