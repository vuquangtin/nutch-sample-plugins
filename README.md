nutch-sample-plugins
======================================================================

<a name="description">description</a>
----------------------------------------------------------------------

* setting

        cd $NUTCH_ROOT/src/plugin/
        git clone git@github.com:fumimaron9/nutch-sample-plugins.git sample-plugins
        cd sample-plugins/

        vim src/plugin/build.xml
        <<<<<
        <ant dir="sample-plugins" target="deploy"/>
        >>>>>

        vim conf/nutch-site.xml
        <<<<<
        <property>
          <name>plugin.includes</name>
          <value>sample-plugins|protocol-http</value>
          <description>Regular expression naming plugin directory names to
          include.  Any plugin not matching this expression is excluded.
          In any case you need at least include the nutch-extensionpoints plugin. By
          default Nutch includes crawling just HTML and plain text via HTTP,
          and basic indexing and search plugins.
          </description>
        </property>
        >>>>>

        cd $NUTCH_ROOT/
        ant

* execute

        ./runtime/local/bin/nutch plugin sample-plugins org.apache.nutch.helloworld.HelloWorld

* test

        cd $NUTCH_ROOT/src/plugin/sample-plugins/
        ant test

----------------------------------------------------------------------
